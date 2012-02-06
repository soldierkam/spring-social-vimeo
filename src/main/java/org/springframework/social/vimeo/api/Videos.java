package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.impl.AbstractCollection;

import java.util.List;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 6:03 PM
 */
public class Videos extends AbstractCollection {

    public Videos(Integer onThisPage, Integer pageNumber, Integer perPage, Integer total, List<Video> videos) {
        super(onThisPage, pageNumber, perPage, total);
        this.videos = videos;
    }

    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }
}
