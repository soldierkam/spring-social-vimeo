package org.springframework.social.vimeo.connect;

import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.util.MultiValueMap;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:44
 */
public class VimeoOAuthTemplate extends OAuth1Template {

    public VimeoOAuthTemplate(String consumerKey, String consumerSecret) {
        super(consumerKey,
                consumerSecret,
                "http://vimeo.com/oauth/request_token",
                "http://vimeo.com/oauth/authorize",
                "http://vimeo.com/oauth/access_token");
    }

    @Override
    protected void addCustomAuthorizationParameters(MultiValueMap<String, String> parameters) {
        parameters.add("permission", VimeoConfig.getPermissionLevel().name().toLowerCase());
    }
}
