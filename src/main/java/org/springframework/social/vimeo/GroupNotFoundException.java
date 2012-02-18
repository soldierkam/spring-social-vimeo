package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 18:36
 */
public class GroupNotFoundException extends ResourceNotFoundException {
    public GroupNotFoundException(String message) {
        super(message);
    }
}
