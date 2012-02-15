package org.springframework.social.vimeo;

/**
 * You must provide a title.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:06
 */
public class BlankTitleException extends InvalidValueException {
    public BlankTitleException(String message) {
        super(message);
    }
}
