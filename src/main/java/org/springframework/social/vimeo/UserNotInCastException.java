package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 22:41
 */
public class UserNotInCastException extends OperationNotPermittedException {
    public UserNotInCastException(String message) {
        super(message);
    }
}
