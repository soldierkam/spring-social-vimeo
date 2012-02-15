package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * The specified user is not a moderator of this channel.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:19
 */
public class UserNotModeratorException extends OperationNotPermittedException {
    public UserNotModeratorException(String message) {
        super(message);
    }
}
