package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 18:12
 */
public class VimeoErrorHandler extends DefaultResponseErrorHandler {

    private final static Map<Integer, Class<? extends RuntimeException>> commonErrors = new HashMap<Integer, Class<? extends RuntimeException>>();
    private final ObjectMapper objectMapper;
    private final Pattern ERROR_RESPONSE_PATTERN = Pattern.compile("\"stat\"\\s*:\\s*\"fail\"", Pattern.DOTALL | Pattern.MULTILINE);

    {
        commonErrors.put(96, InvalidAuthorizationException.class);//Invalid signature The api_sig passed was not valid.
        commonErrors.put(97, MissingAuthorizationException.class);//Missing signature A signature was not passed.
        commonErrors.put(98, InvalidAuthorizationException.class);//Login failed / Invalid auth token The login details or auth token passed were invalid.
        commonErrors.put(100, InvalidAuthorizationException.class);//Invalid API Key The API key passed was not valid.
        commonErrors.put(105, InvalidAuthorizationException.class);//Service currently unavailable The requested service is temporarily unavailable.
        commonErrors.put(111, ApiException.class);//Format not found The requested response format was not found.
        commonErrors.put(112, ApiException.class);//Method not found The requested method was not found.
        commonErrors.put(301, RejectedAuthorizationException.class);//Invalid consumer key The consumer key passed was not valid.
        commonErrors.put(302, RejectedAuthorizationException.class);//Invalid / expired token The oauth_token passed was either not valid or has expired.
        commonErrors.put(303, RejectedAuthorizationException.class);//Invalid signature The oauth_signature passed was not valid.
        commonErrors.put(304, RejectedAuthorizationException.class);//Invalid nonce The oauth_nonce passed has already been used.
        commonErrors.put(305, RejectedAuthorizationException.class);//Invalid signature The oauth_signature passed was not valid.
        commonErrors.put(306, InvalidAuthorizationException.class);//Unsupported signature method We do not support that signature method.
        commonErrors.put(307, ApiException.class);//Missing required parameter A required parameter was missing.
        commonErrors.put(308, ApiException.class);//Duplicate parameter An OAuth protocol parameter was duplicated.
        commonErrors.put(999, RateLimitExceededException.class);//Rate limit exceeded Please wait a few minutes before trying again.
    }

    public VimeoErrorHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (super.hasError(response)) {
            return true;
        }
        String content = readAll(response.getBody());
        return ERROR_RESPONSE_PATTERN.matcher(content).find();
    }

    private String readAll(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }
        return sb.toString();
    }


    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        Error error = readResponse(response);
        if (error == null) {
            super.handleError(response);
        } else {
            if (commonErrors.containsKey(error.getCode())) {
                handleCommonError(error);
            } else {
                handleMethodSpecificError(error, response);
            }
        }
    }

    private void handleCommonError(Error error) {
        Class<? extends RuntimeException> exceptionClass = commonErrors.get(error.getCode());
        RuntimeException excInstance = build(error, exceptionClass);
        throw excInstance;
    }

    public static RuntimeException build(Error err, Class<? extends RuntimeException> exceptionClass) {
        if (exceptionClass == null) {
            throw new ApiException("Unsupported error response: " + err.toString());
        }
        try {
            Constructor<? extends RuntimeException> excConstructor = exceptionClass.getConstructor(String.class);
            return excConstructor.newInstance(err.getMsg());
        } catch (NoSuchMethodException exc) {
            throwException(exceptionClass, err, exc);
        } catch (InstantiationException exc) {
            throwException(exceptionClass, err, exc);
        } catch (IllegalAccessException exc) {
            throwException(exceptionClass, err, exc);
        } catch (InvocationTargetException exc) {
            throwException(exceptionClass, err, exc);
        }
        return throwException(exceptionClass, err, null);
    }

    public static RuntimeException throwException(Class<? extends RuntimeException> exceptionClass, Error err, Exception cause) {
        final String msg = "Cannot build exception " + exceptionClass.getName() + " for response " + err.toString();
        if (cause == null) {
            throw new ApiException(msg);
        } else {
            throw new ApiException(msg, cause);
        }
    }

    private void handleMethodSpecificError(Error error, ClientHttpResponse response) {
        throw new MethodSpecificErrorException(error);
    }

    private Error readResponse(ClientHttpResponse response) throws IOException {
        try {
            ErrorResponse decodedJson = objectMapper.readValue(response.getBody(), ErrorResponse.class);
            return decodedJson.getError();
        } catch (Exception exc) {
            return null;
        }
    }

}
