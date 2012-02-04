package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.Video;
import org.springframework.social.vimeo.api.VideoOperations;
import org.springframework.social.vimeo.api.Videos;
import org.springframework.social.vimeo.api.VideosSortMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:13 PM
 */
public class VideoTemplate extends AbstractVimeoTemplate implements VideoOperations{

    private final static VimeoMethod SEARCH_METHOD = new VimeoMethodImpl("vimeo.videos.search", "videos");

    public VideoTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public Videos search(String query, Integer page, Integer perPage, VideosSortMethod sortBy, String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("full_response", "1");
        params.add("query", query);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        params.addIfNotNull("sort", sortBy);
        params.addIfNotNull("userId", userId);
        return getObject(SEARCH_METHOD, params.build(), Videos.class);
    }
}
