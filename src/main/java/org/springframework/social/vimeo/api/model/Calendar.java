package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:15
 */
public class Calendar {
    private String type;//TODO: enum?

    public Calendar(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
