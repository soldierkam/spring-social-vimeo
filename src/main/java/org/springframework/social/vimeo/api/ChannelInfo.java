package org.springframework.social.vimeo.api;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 9:54 PM
 */
public class ChannelInfo {
    private String id;
    private Boolean featured;
    private Boolean sponsored;
    private Boolean subscribed;
    private String name;
    private String description;
    private Date createdOn;
    private Date modifiedOn;
    private Integer totalVideos;
    private Integer totalSubscribers;
    private URL logoUrl;
    private URL badgeUrl;
    private URL thumbnailUrl;
    private List<URL> urls;
    private ChannelLayout layout;
    private String theme;
    private Privacy privacy;
    private Person creator;

    public ChannelInfo(String id, Boolean featured, Boolean sponsored, Boolean subscribed, String name, String description, Date createdOn, Date modifiedOn, Integer totalVideos, Integer totalSubscribers, URL logoUrl, URL badgeUrl, URL thumbnailUrl, List<URL> urls, ChannelLayout layout, String theme, Privacy privacy, Person creator) {
        this.id = id;
        this.featured = featured;
        this.sponsored = sponsored;
        this.subscribed = subscribed;
        this.name = name;
        this.description = description;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.totalVideos = totalVideos;
        this.totalSubscribers = totalSubscribers;
        this.logoUrl = logoUrl;
        this.badgeUrl = badgeUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.urls = urls;
        this.layout = layout;
        this.theme = theme;
        this.privacy = privacy;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public Integer getTotalSubscribers() {
        return totalSubscribers;
    }

    public URL getLogoUrl() {
        return logoUrl;
    }

    public URL getBadgeUrl() {
        return badgeUrl;
    }

    public URL getThumbnailUrl() {
        return thumbnailUrl;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public ChannelLayout getLayout() {
        return layout;
    }

    public String getTheme() {
        return theme;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public Person getCreator() {
        return creator;
    }
}
