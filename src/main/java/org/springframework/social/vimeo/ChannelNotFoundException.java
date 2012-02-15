package org.springframework.social.vimeo;

import org.springframework.social.ResourceNotFoundException;

/**
 * The channel id or name was either not valid or not provided.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:15
 */
public class ChannelNotFoundException extends ResourceNotFoundException {
    public ChannelNotFoundException(String message) {
        super(message);
    }
}
