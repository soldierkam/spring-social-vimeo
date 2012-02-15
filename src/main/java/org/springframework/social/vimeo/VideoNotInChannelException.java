package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * The specified video is not in this channel.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:20
 */
public class VideoNotInChannelException extends ApiException {
    public VideoNotInChannelException(String message) {
        super(message);
    }
}
