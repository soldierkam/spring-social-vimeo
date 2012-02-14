package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 9:54 PM
 */
public class ChannelInfo extends Channel {
    private Boolean featured;
    private Boolean sponsored;
    private Boolean subscribed;
    private String description;
    private Date createdOn;
    private Date modifiedOn;
    private Integer totalVideos;
    private Integer totalSubscribers;
    private URL badgeUrl;
    private URL thumbnailUrl;
    private ChannelLayout layout;
    private String theme;
    private Privacy privacy;
    private ProPerson creator;

    protected ChannelInfo(String id, Boolean featured, Boolean sponsored, Boolean subscribed, String name, String description, Date createdOn, Date modifiedOn, Integer totalVideos, Integer totalSubscribers, URL logoUrl, URL badgeUrl, URL thumbnailUrl, List<URL> urls, ChannelLayout layout, String theme, Privacy privacy, ProPerson creator) {
        super(id, name, logoUrl, urls);
        this.featured = featured;
        this.sponsored = sponsored;
        this.subscribed = subscribed;
        this.description = description;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.totalVideos = totalVideos;
        this.totalSubscribers = totalSubscribers;
        this.badgeUrl = badgeUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.layout = layout;
        this.theme = theme;
        this.privacy = privacy;
        this.creator = creator;
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

    public URL getBadgeUrl() {
        return badgeUrl;
    }

    public URL getThumbnailUrl() {
        return thumbnailUrl;
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

    public ProPerson getCreator() {
        return creator;
    }
}
