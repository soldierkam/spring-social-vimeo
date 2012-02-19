package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 22:47
 */
public class TagNotFoundException extends ResourceNotFoundException {
    public TagNotFoundException(String message) {
        super(message);
    }
}
