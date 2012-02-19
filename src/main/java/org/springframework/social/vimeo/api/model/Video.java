package org.springframework.social.vimeo.api.model;

import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:28 PM
 */
public class Video {

    private Boolean allowAdds;
    private String embedPrivacy;
    private Integer id;
    private Boolean hd;
    private Boolean transcoding;
    private CreativeCommonLicenseType license;
    private Privacy privacy;
    private String title;
    private String description;
    private Date uploadDate;
    private Date modifiedDate;
    private Integer numberOfLikes;
    private Integer numberOfPlays;
    private Integer numberOfComments;
    private Integer width;
    private Integer height;
    private Integer duration;
    private ProPerson owner;
    private List<Image> thumbnails;

    protected Video(Boolean allowAdds, String embedPrivacy, Integer id, Boolean hd, Boolean transcoding, CreativeCommonLicenseType license, Privacy privacy, String title, String description, Date uploadDate, Date modifiedDate, Integer numberOfLikes, Integer numberOfPlays, Integer numberOfComments, Integer width, Integer height, Integer duration, ProPerson owner) {
        this.allowAdds = allowAdds;
        this.embedPrivacy = embedPrivacy;
        this.id = id;
        this.hd = hd;
        this.transcoding = transcoding;
        this.license = license;
        this.privacy = privacy;
        this.title = title;
        this.description = description;
        this.uploadDate = uploadDate;
        this.modifiedDate = modifiedDate;
        this.numberOfLikes = numberOfLikes;
        this.numberOfPlays = numberOfPlays;
        this.numberOfComments = numberOfComments;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.owner = owner;
    }

    public Boolean getAllowAdds() {
        return allowAdds;
    }

    public String getEmbedPrivacy() {
        return embedPrivacy;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getHd() {
        return hd;
    }

    public Boolean getTranscoding() {
        return transcoding;
    }

    public CreativeCommonLicenseType getLicense() {
        return license;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public Integer getNumberOfPlays() {
        return numberOfPlays;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getDuration() {
        return duration;
    }

    public ProPerson getOwner() {
        return owner;
    }

    public List<Image> getThumbnails() {
        return thumbnails;
    }
}
