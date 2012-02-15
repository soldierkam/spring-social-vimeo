package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * User: soldier
 * Date: 15.02.12
 * Time: 23:06
 */
public class InvalidValueException extends ApiException {
    public InvalidValueException(String message) {
        super(message);
    }
}
