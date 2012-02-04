package org.springframework.social.vimeo.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:25 AM
 */
public class ThumbnailVideo {


    public ThumbnailVideo(String id, String ownerId, String title, List<Thumbnail> thumbnails) {
        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.thumbnails = thumbnails;
    }

    private String id;
    private String ownerId;
    private String title;
    private List<Thumbnail> thumbnails;

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }
}
