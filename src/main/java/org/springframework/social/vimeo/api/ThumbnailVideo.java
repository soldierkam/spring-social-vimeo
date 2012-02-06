package org.springframework.social.vimeo.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:25 AM
 */
public class ThumbnailVideo {


    public ThumbnailVideo(String id, String ownerId, String title, List<Image> thumbnails) {
        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.thumbnails = thumbnails;
    }

    private String id;
    private String ownerId;
    private String title;
    private List<Image> thumbnails;

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public List<Image> getThumbnails() {
        return thumbnails;
    }
}
