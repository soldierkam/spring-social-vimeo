package org.springframework.social.vimeo.api.impl;

import org.springframework.social.vimeo.api.model.PermissionLevel;

/**
 * User: soldier
 * Date: 24.02.12
 * Time: 19:20
 */
public class Permission {
    private PermissionLevel level;

    public Permission(PermissionLevel level) {
        this.level = level;
    }

    public PermissionLevel getLevel() {
        return level;
    }

    public void setLevel(PermissionLevel level) {
        this.level = level;
    }
}
