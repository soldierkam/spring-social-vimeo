package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 00:56
 */
public class UserNotPlusException extends OperationNotPermittedException {
    public UserNotPlusException(String message) {
        super(message);
    }
}
