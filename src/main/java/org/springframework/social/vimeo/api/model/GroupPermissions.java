package org.springframework.social.vimeo.api.model;

import java.util.Map;

/**
 * User: soldier
 * Date: 22.06.12
 * Time: 18:34
 */
public class GroupPermissions {
    private boolean canUsersApply;
    private GroupType groupType;
    private Map<PermissionName, GroupRole> permissions;

    protected GroupPermissions(boolean canUsersApply, GroupType groupType, Map<PermissionName, GroupRole> permissions) {
        this.canUsersApply = canUsersApply;
        this.groupType = groupType;
        this.permissions = permissions;
    }

    public boolean isCanUsersApply() {
        return canUsersApply;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public GroupRole get(PermissionName name) {
        return permissions.get(name);
    }
}
