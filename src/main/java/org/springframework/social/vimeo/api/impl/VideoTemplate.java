package org.springframework.social.vimeo.api.impl;

import org.springframework.social.vimeo.api.Video;
import org.springframework.social.vimeo.api.VideoOperations;
import org.springframework.social.vimeo.api.VideosSortMethod;

import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:13 PM
 */
public class VideoTemplate implements VideoOperations{
    @Override
    public List<Video> search(String query, Integer page, Integer perPage, VideosSortMethod sortBy, String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
