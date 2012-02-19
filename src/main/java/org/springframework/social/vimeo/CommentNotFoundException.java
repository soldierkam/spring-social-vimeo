package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 01:01
 */
public class CommentNotFoundException extends ResourceNotFoundException {
    public CommentNotFoundException(String message) {
        super(message);
    }
}
