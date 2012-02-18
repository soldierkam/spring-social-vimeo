package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 18:37
 */
public class UserNotMemberException extends OperationNotPermittedException {
    public UserNotMemberException(String message) {
        super(message);
    }
}
