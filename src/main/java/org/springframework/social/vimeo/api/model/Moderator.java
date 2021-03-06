package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:27 PM
 */
public class Moderator extends ProPerson {
    private Boolean creator;

    protected Moderator(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, List<Portrait> portraits) {
        super(id, displayName, plus, pro, staff, profileUrl, realName, userName, videosUrl, portraits);
    }

    public Boolean getCreator() {
        return creator;
    }
}
