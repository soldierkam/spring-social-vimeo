package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 01:20
 */
public class InvalidEmbedPresetException extends ResourceNotFoundException {
    public InvalidEmbedPresetException(String message) {
        super(message);
    }
}
