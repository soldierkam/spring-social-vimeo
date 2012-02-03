package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:47 PM
 */
public interface VideoOperations {

    List<Video> search(String query, Integer page, Integer perPage, VideosSortMethod sortBy, String userId);
}
