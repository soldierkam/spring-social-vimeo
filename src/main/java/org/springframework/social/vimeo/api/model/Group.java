package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:58
 */
public class Group {
    private String id;
    private Boolean featured;
    private String name;
    private Date createdOn;
    private Date modifiedOn;
    private Integer totalVideos;
    private Integer totalMembers;
    private Integer totalThreads;
    private Integer totalFiles;
    private Integer totalEvents;
    private List<URL> url;
    private Permissions permissions;
    private Calendar calendar;
    private Person creator;

    protected Group(String id, Boolean featured, String name, Date createdOn, Date modifiedOn, Integer totalVideos, Integer totalMembers, Integer totalThreads, Integer totalFiles, Integer totalEvents, List<URL> url, Permissions permissions, Calendar calendar, Person creator) {
        this.id = id;
        this.featured = featured;
        this.name = name;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.totalVideos = totalVideos;
        this.totalMembers = totalMembers;
        this.totalThreads = totalThreads;
        this.totalFiles = totalFiles;
        this.totalEvents = totalEvents;
        this.url = url;
        this.permissions = permissions;
        this.calendar = calendar;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public Integer getTotalVideos() {
        return totalVideos;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public Integer getTotalThreads() {
        return totalThreads;
    }

    public Integer getTotalFiles() {
        return totalFiles;
    }

    public Integer getTotalEvents() {
        return totalEvents;
    }

    public List<URL> getUrl() {
        return url;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Person getCreator() {
        return creator;
    }
}
