package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:59 PM
 */
public class ProPerson extends Person {

    private Boolean pro;

    public ProPerson(String id, String displayName, Boolean plus, Boolean pro, Boolean staff, URL profileUrl, String realName, String userName, URL videosUrl, List<Portrait> portraits) {
        super(id, displayName, plus, staff, profileUrl, realName, userName, videosUrl, portraits);
        this.pro = pro;
    }

    public Boolean getPro() {
        return pro;
    }
}
