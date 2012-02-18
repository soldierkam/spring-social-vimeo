package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 19:22
 */
public class VideoNotAddedToGroupException extends ApiException {
    public VideoNotAddedToGroupException(String message) {
        super(message);
    }
}
