package org.springframework.social.vimeo.api;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:59 PM
 */
public class Owner {

    private String id;
    private String displayName;
    private Boolean plus;
    private Boolean pro;
    private Boolean staff;
    private URL profileUrl;
    private String realName;
    private String userName;
    private URL videosUrl;
    private List<Portrait> portraits;

    public Owner(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl) {
        this.id = id;
        this.displayName = displayName;
        this.plus = plus;
        this.pro = pro;
        this.staff = staff;
        this.profileUrl = profileUrl;
        this.realName = realName;
        this.userName = userName;
        this.videosUrl = videosUrl;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Boolean getPlus() {
        return plus;
    }

    public Boolean getPro() {
        return pro;
    }

    public Boolean getStaff() {
        return staff;
    }

    public URL getProfileUrl() {
        return profileUrl;
    }

    public String getRealName() {
        return realName;
    }

    public String getUserName() {
        return userName;
    }

    public URL getVideosUrl() {
        return videosUrl;
    }

    public List<Portrait> getPortraits() {
        return portraits;
    }
}
