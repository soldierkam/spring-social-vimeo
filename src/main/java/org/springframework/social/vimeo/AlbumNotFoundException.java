package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 15.02.12
 * Time: 23:00
 */
public class AlbumNotFoundException extends ResourceNotFoundException {
    public AlbumNotFoundException(String message) {
        super(message);
    }
}
