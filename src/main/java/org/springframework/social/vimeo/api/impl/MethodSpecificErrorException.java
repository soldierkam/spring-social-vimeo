package org.springframework.social.vimeo.api.impl;

/**
 * User: soldier
 * Date: 15.02.12
 * Time: 22:27
 */
public class MethodSpecificErrorException extends RuntimeException {
    private final Error error;

    public MethodSpecificErrorException(Error error) {
        if (error == null) {
            throw new NullPointerException();
        }
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
