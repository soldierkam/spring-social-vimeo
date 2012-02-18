package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 18:40
 */
public class AlreadyMemberException extends ApiException {
    public AlreadyMemberException(String message) {
        super(message);
    }
}
