package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.Credentials;
import org.springframework.social.vimeo.api.model.OAuthToken;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 21:25
 */
public interface OAuthOperations {
    /**
     * Return the credentials attached to an Access Token.
     */
    Credentials checkAccessToken();

    /**
     * Convert an old auth token to an OAuth Access Token.
     * After you call this method the old auth token will no longer be valid.
     */
    OAuthToken convertAuthToken(String authToken);
}
