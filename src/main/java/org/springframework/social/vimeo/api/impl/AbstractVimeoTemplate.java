package org.springframework.social.vimeo.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.social.ApiException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:26 PM
 */
class AbstractVimeoTemplate {

    private final Log log = LogFactory.getLog(getClass());

    protected boolean secure = true;
    protected final RestTemplate restTemplate;
    protected final ObjectMapper objectMapper;

    protected AbstractVimeoTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = mapper;
    }

    private String getUri(MultiValueMap<String, Object> params) {
        StringBuilder url = new StringBuilder(secure ? "https://vimeo.com/api/rest/v2?" : "http://vimeo.com/api/rest/v2?");
        for(Map.Entry<String, List<Object>> p : params.entrySet()){
            for(Object value : p.getValue()){
                url.append(encode(p.getKey())).append("=").append(encode(value.toString())).append("&");
            }
        }
        return url.toString();
    }
    
    private String encode(String e){
        try{
            return URLEncoder.encode(e, "UTF-8");
        }catch (UnsupportedEncodingException exc){
            throw new RuntimeException(exc);
        }
    }

    protected <T> List<T> getObjects(VimeoMethod method, MultiValueMap<String, Object> p, Class<T> type) {
        try {
            if(log.isDebugEnabled()){
                log.debug("Call " + method.name());
            }
            JsonNode node = restTemplate.getForObject(getUri(createParamsMap(method, p)), JsonNode.class);
            JsonNode data = node.get(method.dataNodeName());
            return deserializeDataList(data, type);
        } catch (MethodSpecificErrorException exc) {
            handleMethodSpecificError(exc, method);
            return null;
        }
    }

    protected <T> T getObject(VimeoMethod method, MultiValueMap<String, Object> p, Class<T> type) {
        try {
            if(log.isDebugEnabled()){
                log.debug("Call " + method.name());
            }
            JsonNode node = restTemplate.getForObject(getUri(createParamsMap(method, p)), JsonNode.class);
            if (method.hasDataNodeName()) {
                if (!node.has(method.dataNodeName())) {
                    throw new ApiException("Invalid JSON response: missing field \"" + method.dataNodeName() + "\"");
                }
                node = node.get(method.dataNodeName());
            }
            return objectMapper.readValue(node, type);
        } catch (IOException e) {
            throw new UncategorizedApiException("Error deserializing data from Vimeo: " + e.getMessage(), e);
        } catch (MethodSpecificErrorException exc) {
            handleMethodSpecificError(exc, method);
            return null;
        }

    }

    private MultiValueMap<String, Object> createParamsMap(VimeoMethod method, MultiValueMap<String, Object> p) {
        MultiValueMap params = p == null ? new LinkedMultiValueMap() : new LinkedMultiValueMap(p);
        params.add("method", method.name());
        params.add("format", "json");
        return params;
    }

    protected void doMethod(VimeoMethod method, MultiValueMap<String, Object> p) {
        try {
            if(log.isDebugEnabled()){
                log.debug("Call " + method.name());
            }
            restTemplate.getForObject(getUri(createParamsMap(method, p)), JsonNode.class);
        } catch (MethodSpecificErrorException exc) {
            handleMethodSpecificError(exc, method);
        }
    }

    protected String doAction(VimeoMethod method, MultiValueMap<String, Object> p) {
        if(log.isDebugEnabled()){
            log.debug("Call " + method.name());
        }
        JsonNode node = restTemplate.getForObject(getUri(createParamsMap(method, p)), JsonNode.class);
        JsonNode arrayOfObject = node.get(method.dataNodeName());
        return arrayOfObject.get(0).get("id").getTextValue();
    }

    private <T> List<T> deserializeDataList(JsonNode jsonNode, final Class<T> elementType) {
        if (jsonNode.size() == 1) {
            jsonNode = jsonNode.get(jsonNode.getFieldNames().next());
        }
        try {
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
            return (List<T>) objectMapper.readValue(jsonNode, listType);
        } catch (IOException e) {
            throw new UncategorizedApiException("Error deserializing data from Vimeo: " + e.getMessage(), e);
        }
    }

    private void handleMethodSpecificError(MethodSpecificErrorException exc, VimeoMethod method) {
        Class<? extends RuntimeException> clazz = method.getErrorHandler(exc.getError().getCode());
        RuntimeException newExc = VimeoErrorHandler.build(exc.getError(), clazz);
        throw newExc;
    }

    protected class ParamsBuilder {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>(10);

        public void addIfNotNull(String name, Integer value, Integer max) {
            if (name == null) {
                throw new IllegalArgumentException();
            }
            if (value != null) {
                if (max != null && value > max) {
                    throw new IllegalArgumentException("Value is bigger than max");
                }
                doAdd(name, value);
            }
        }

        public void addIfNotNull(String name, Object value) {
            if (name == null) {
                throw new IllegalArgumentException();
            }
            if (value != null) {
                doAdd(name, value);
            }
        }

        public void add(String name, Object value) {
            if (value == null || name == null) {
                throw new IllegalArgumentException();
            }
            doAdd(name, value);
        }

        public void add(String name, Integer value, Integer max) {
            if (value == null) {
                throw new NullPointerException();
            }
            if (max != null && value > max) {
                throw new IllegalArgumentException("Value is bigger than max");
            }
            add(name, value);
        }

        public void add(String name, Object value, Object defaultValue) {
            Object toSet = value == null ? defaultValue : value;
            add(name, toSet);
        }

        public MultiValueMap<String, Object> build() {
            return new LinkedMultiValueMap<String, Object>(params);
        }

        private void doAdd(String name, Object value) {
            if (value instanceof Collection) {
                Collection values = (Collection) value;
                value = StringUtils.collectionToCommaDelimitedString(values);
            }
            params.add(name, value);
        }
    }
}
