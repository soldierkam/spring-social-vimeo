package org.springframework.social.vimeo.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.vimeo.api.Vimeo;
import org.springframework.social.vimeo.api.model.User;
import org.springframework.util.CollectionUtils;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:53
 */
public class VimeoAdapter implements ApiAdapter<Vimeo> {
    @Override
    public boolean test(Vimeo api) {
        try {
            api.peopleOperations().info(null);
            return true;
        } catch (ApiException exc) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Vimeo api, ConnectionValues values) {
        User user = api.peopleOperations().info(null);
        values.setDisplayName(user.getDisplayName());
        if (!CollectionUtils.isEmpty(user.getPortraits())) {
            values.setImageUrl(user.getPortraits().get(0).getUrl().toString());
        }
        values.setProfileUrl(user.getProfileUrl().toString());
        values.setProviderUserId(user.getId());
    }

    @Override
    public UserProfile fetchUserProfile(Vimeo api) {
        User user = api.peopleOperations().info(null);
        return new UserProfileBuilder().setUsername(user.getUsername()).build();
    }

    @Override
    public void updateStatus(Vimeo api, String message) {
    }
}
