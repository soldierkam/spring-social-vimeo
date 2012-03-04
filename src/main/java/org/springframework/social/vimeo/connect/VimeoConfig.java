package org.springframework.social.vimeo.connect;

import org.springframework.social.vimeo.api.model.PermissionLevel;

import java.io.Serializable;

/**
 * User: soldier
 * Date: 24.02.12
 * Time: 19:56
 */
public class VimeoConfig implements Serializable {

    private final static VimeoConfig instance = new VimeoConfig();
    private PermissionLevel permissionLevel = PermissionLevel.WRITE;

    private VimeoConfig() {
    }

    public static void setPermission(PermissionLevel permissionLevel) {
        getInstance().permissionLevel = permissionLevel;
    }

    protected static VimeoConfig getInstance() {
        return instance;
    }

    public static PermissionLevel getPermissionLevel() {
        return getInstance().permissionLevel;
    }
}
