package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * The user is already subscribed to that channel.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:17
 */
public class AlreadySubscribedException extends ApiException {
    public AlreadySubscribedException(String message) {
        super(message);
    }
}
