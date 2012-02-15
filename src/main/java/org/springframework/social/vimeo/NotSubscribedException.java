package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * The specified user is not subscribed to that channel.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:15
 */
public class NotSubscribedException extends ApiException {
    public NotSubscribedException(String message) {
        super(message);
    }
}
