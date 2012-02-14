package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 20:48
 */
public class SimplePerson {
    private String id;
    private String username;
    private String displayName;

    protected SimplePerson(String id, String username, String displayName) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }
}
