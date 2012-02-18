package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 17.02.12
 * Time: 00:08
 */
public class TopicNotFoundException extends ResourceNotFoundException {
    public TopicNotFoundException(String message) {
        super(message);
    }
}
