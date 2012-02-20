package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:18 PM
 */
public class Contact extends ProPerson {

    private Boolean mutual;

    protected Contact(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, Boolean mutual, List<Portrait> portraits) {
        super(id, displayName, plus, pro, staff, profileUrl, realName, userName, videosUrl, portraits);
        this.mutual = mutual;
    }

    public Boolean getMutual() {
        return mutual;
    }
}
