package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.GroupModerators;
import org.springframework.social.vimeo.api.model.Groups;
import org.springframework.social.vimeo.api.model.VideoCollectionSortMethod;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 7:25 PM
 */
public interface GroupOperations {

    /**
     * Get a list of the group's moderators.
     */
    GroupModerators moderators(String groupId, Integer page, Integer perPage);

    /**
     * Add a video to a group.
     */
    void addVideo(String groupId, String videoId);

    /**
     * Join a group.
     */
    void join(String groupId);

    /**
     * Get a list of the groups available to add a video to.
     */
    Groups addable(String userId, VideoCollectionSortMethod sort, Integer page, Integer perPage);

    /**
     * Get a list of all public groups.
     */
    Groups all(String userId, VideoCollectionSortMethod sort, Integer page, Integer perPage);
}
