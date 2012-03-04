package org.springframework.social.vimeo.api.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:38
 */
public enum PermissionLevel {
    READ(1),
    WRITE(2),
    DELETE(3);

    private int l;

    private PermissionLevel(int level) {
        this.l = level;
    }

    public static Set<PermissionLevel> whatCanDo(PermissionLevel level) {
        Set<PermissionLevel> canDo = new HashSet<PermissionLevel>(PermissionLevel.values().length);
        for (PermissionLevel permissionLevel : PermissionLevel.values()) {
            if (level.canDo(permissionLevel)) {
                canDo.add(permissionLevel);
            }
        }
        return canDo;
    }

    public boolean canDo(PermissionLevel permissionLevel) {
        return permissionLevel.l <= this.l;
    }
}
