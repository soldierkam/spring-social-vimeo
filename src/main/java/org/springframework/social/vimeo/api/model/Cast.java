package org.springframework.social.vimeo.api.model;

import java.net.URL;

/**
 * User: soldier
 * Date: 11.02.12
 * Time: 23:28
 */
public class Cast extends ProPerson {
    private String cast;

    protected Cast(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, String cast) {
        super(id, displayName, plus, pro, staff, profileUrl, realName, userName, videosUrl);
        this.cast = cast;
    }

    public String getCast() {
        return cast;
    }
}
