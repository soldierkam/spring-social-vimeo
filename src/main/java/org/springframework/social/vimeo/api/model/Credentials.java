package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:38
 */
public class Credentials {
    private String token;
    private PermissionLevel permission;
    private SimplePerson user;

    public String getToken() {
        return token;
    }

    public PermissionLevel getPermission() {
        return permission;
    }

    public SimplePerson getUser() {
        return user;
    }

    protected Credentials(String token, PermissionLevel permission, SimplePerson user) {

        this.token = token;
        this.permission = permission;
        this.user = user;
    }
}
