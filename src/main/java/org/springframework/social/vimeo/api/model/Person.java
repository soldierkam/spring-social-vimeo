package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:23
 */
public class Person extends SimplePerson {

    private Boolean plus;
    private Boolean staff;
    private URL profileUrl;
    private String realName;
    private URL videosUrl;
    private List<Portrait> portraits;

    protected Person(String id, String displayName, Boolean plus, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl) {
        super(id, userName, displayName);
        this.plus = plus;
        this.staff = staff;
        this.profileUrl = profileUrl;
        this.realName = realName;
        this.videosUrl = videosUrl;
    }

    public Boolean getPlus() {
        return plus;
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

    public URL getVideosUrl() {
        return videosUrl;
    }

    public List<Portrait> getPortraits() {
        return portraits;
    }
}
