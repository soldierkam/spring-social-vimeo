package org.springframework.social.vimeo.api.model;

import java.net.URL;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:31
 */
public class GroupModerator extends Person {
    private String title;

    protected GroupModerator(String id, String displayName, Boolean plus, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, String title) {
        super(id, displayName, plus, staff, profileUrl, realName, userName, videosUrl);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
