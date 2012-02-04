package org.springframework.social.vimeo.api;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:27 PM
 */
public class Album {

    private String id;
    private String title;
    private String description;
    private Date createOn;
    private Integer totalVideos;
    private List<URL> urls;
    private VideosSortMethod sortMethod;
    private ThumbnailVideo thumbnail;

    public Album(String id, String title, String description, Date createOn, Integer totalVideos, List<URL> urls, VideosSortMethod sortMethod, ThumbnailVideo thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createOn = createOn;
        this.totalVideos = totalVideos;
        this.urls = urls;
        this.sortMethod = sortMethod;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public Integer getTotalVideos() {
        return totalVideos;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public VideosSortMethod getSortMethod() {
        return sortMethod;
    }

    public ThumbnailVideo getThumbnail() {
        return thumbnail;
    }
}
