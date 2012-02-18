package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.UserNotFoundException;
import org.springframework.social.vimeo.api.OAuthOperations;
import org.springframework.social.vimeo.api.model.Credentials;
import org.springframework.social.vimeo.api.model.OAuthToken;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 21:32
 */
public class OAuthTemplate extends AbstractVimeoTemplate implements OAuthOperations {

    private final static VimeoMethod CHECK = new VimeoMethodImpl("vimeo.oauth.checkAccessToken", "") {{
        add(1, UserNotFoundException.class);
    }};
    private final static VimeoMethod CONVERT = new VimeoMethodImpl("vimeo.oauth.convertAuthToken", "");

    public OAuthTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public Credentials checkAccessToken() {
        return getObject(CHECK, null, Credentials.class);
    }

    @Override
    public OAuthToken convertAuthToken(String authToken) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("auth_token", authToken);
        return getObject(CONVERT, params.build(), OAuthToken.class);
    }
}
