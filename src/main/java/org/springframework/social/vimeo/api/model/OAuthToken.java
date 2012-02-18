package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 21:26
 */
public class OAuthToken {
    private String token;
    private String secret;

    public OAuthToken(String token, String secret) {
        this.token = token;
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public String getSecret() {
        return secret;
    }
}
