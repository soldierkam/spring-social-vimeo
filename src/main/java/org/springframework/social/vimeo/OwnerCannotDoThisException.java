package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 22:42
 */
public class OwnerCannotDoThisException extends OperationNotPermittedException {
    public OwnerCannotDoThisException(String message) {
        super(message);
    }
}
