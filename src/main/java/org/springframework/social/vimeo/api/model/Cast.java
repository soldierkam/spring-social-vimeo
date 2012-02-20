package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 11.02.12
 * Time: 23:28
 */
public class Cast extends ProPerson {
    private String cast;

    protected Cast(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, String cast, List<Portrait> portraits) {
        super(id, displayName, plus, pro, staff, profileUrl, realName, userName, videosUrl, portraits);
        this.cast = cast;
    }

    public String getCast() {
        return cast;
    }
}
