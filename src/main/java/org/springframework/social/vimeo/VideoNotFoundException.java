package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * The video id was either invalid or was for a video not viewable by the calling user.
 * User: soldier
 * Date: 15.02.12
 * Time: 22:56
 */
public class VideoNotFoundException extends ResourceNotFoundException {
    public VideoNotFoundException(String message) {
        super(message);
    }
}
