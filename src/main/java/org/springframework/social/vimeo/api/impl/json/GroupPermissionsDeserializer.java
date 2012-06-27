package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.GroupPermissions;
import org.springframework.social.vimeo.api.model.GroupRole;
import org.springframework.social.vimeo.api.model.GroupType;
import org.springframework.social.vimeo.api.model.PermissionName;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * User: soldier
 * Date: 22.06.12
 * Time: 18:48
 */
public class GroupPermissionsDeserializer extends JsonDeserializer<GroupPermissions> {
    @Override
    public GroupPermissions deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            Map<String, String> values = jp.readValueAs(Map.class);
            boolean canUsersApply = getBoolean(values, "can_users_apply");
            GroupType groupType = GroupType.valueOf(values.get("group_type").toUpperCase());
            values.remove("can_users_apply");
            values.remove("group_type");
            return construct(canUsersApply,
                    groupType,
                    toPermissionMap(values));
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read", jp.getCurrentLocation(), exc);
        } catch (Exception exc) {
            throw new JsonParseException("Cannot read", jp.getCurrentLocation(), exc);
        }
    }

    private GroupPermissions construct(boolean canUsersApply, GroupType groupType, Map<PermissionName, GroupRole> permissions) throws Exception {
        Constructor<GroupPermissions> constructor = GroupPermissions.class.getDeclaredConstructor(boolean.class, GroupType.class, Map.class);
        constructor.setAccessible(true);
        return constructor.newInstance(canUsersApply, groupType, permissions);
    }

    private boolean getBoolean(Map<String, String> map, String name) {
        String value = map.get(name);
        if ("0".equals(value)) {
            return false;
        } else if ("1".equals(value)) {
            return true;
        } else {
            throw new IllegalArgumentException("Illegal boolean value for " + name + ": " + value);
        }
    }

    private Map<PermissionName, GroupRole> toPermissionMap(Map<String, String> inputMap) {
        Map<PermissionName, GroupRole> result = new HashMap<PermissionName, GroupRole>(inputMap.size());
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            result.put(PermissionName.valueOf(entry.getKey().toUpperCase()), GroupRole.valueOf(entry.getValue().toUpperCase()));
        }
        return result;
    }
}