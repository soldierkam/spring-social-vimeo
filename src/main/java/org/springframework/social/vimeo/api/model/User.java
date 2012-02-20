package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 21:30
 */
public class User extends Person {

    private Date createdOn;
    private Boolean contact;
    private Boolean subscribedTo;
    private String location;
    private List<URL> url;
    private String biography;
    private Integer contacts;
    private Integer uploads;
    private Integer likes;
    private Integer videos;
    private Integer videosAppearsIn;
    private Integer albums;
    private Integer channels;
    private Integer groups;

    protected User(String id, String displayName, Boolean plus, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, Date createdOn, Boolean contact, Boolean subscribedTo, String location, List<URL> url, String biography, Integer contacts, Integer uploads, Integer likes, Integer videos, Integer videosAppearsIn, Integer albums, Integer channels, Integer groups, List<Portrait> portraits) {
        super(id, displayName, plus, staff, profileUrl, realName, userName, videosUrl, portraits);
        this.createdOn = createdOn;
        this.contact = contact;
        this.subscribedTo = subscribedTo;
        this.location = location;
        this.url = url;
        this.biography = biography;
        this.contacts = contacts;
        this.uploads = uploads;
        this.likes = likes;
        this.videos = videos;
        this.videosAppearsIn = videosAppearsIn;
        this.albums = albums;
        this.channels = channels;
        this.groups = groups;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Boolean getContact() {
        return contact;
    }

    public Boolean getSubscribedTo() {
        return subscribedTo;
    }

    public String getLocation() {
        return location;
    }

    public List<URL> getUrl() {
        return url;
    }

    public String getBiography() {
        return biography;
    }

    public Integer getContacts() {
        return contacts;
    }

    public Integer getUploads() {
        return uploads;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getVideos() {
        return videos;
    }

    public Integer getVideosAppearsIn() {
        return videosAppearsIn;
    }

    public Integer getAlbums() {
        return albums;
    }

    public Integer getChannels() {
        return channels;
    }

    public Integer getGroups() {
        return groups;
    }
}
