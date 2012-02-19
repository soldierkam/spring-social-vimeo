package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 23:15
 */
public class InvalidLicenseException extends ApiException {
    public InvalidLicenseException(String message) {
        super(message);
    }
}
