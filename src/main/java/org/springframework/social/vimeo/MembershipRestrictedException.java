package org.springframework.social.vimeo;

import org.springframework.social.OperationNotPermittedException;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 18:41
 */
public class MembershipRestrictedException extends OperationNotPermittedException {
    public MembershipRestrictedException(String message) {
        super(message);
    }
}
