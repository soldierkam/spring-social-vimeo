package org.springframework.social.vimeo;

import org.springframework.social.ApiException;

/**
 * Only Plus members can create more than 3 albums.
 * User: soldier
 * Date: 15.02.12
 * Time: 23:04
 */
public class AlbumLimitReachedException extends ApiException {
    public AlbumLimitReachedException(String message) {
        super(message);
    }
}
