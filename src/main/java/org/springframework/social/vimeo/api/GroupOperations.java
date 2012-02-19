package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.*;

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

    /**
     * Get information for a specific group.
     */
    Group info(String groupId);

    /**
     * Leave a group.
     */
    void leave(String groupId);

    /**
     * Get a list of the members of a group.
     */
    People members(String groupId);

    /**
     * Get a list of the videos added to a group.
     */
    Videos videos(String groupId, VideosInGroupSortMethod sort, Integer page, Integer perPage);

    /**
     * Remove a video from a group.
     */
    void removeVideo(String groupId, String videoId);

    /**
     * Get a list of the comments on a video in a group.
     */
    FullComments videoComments(String groupId, String videoId, Integer page, Integer perPage);

    /**
     * Get a list of comments in a group forum topic.
     */
    FullComments topicComments(String groupId, String topicId, Integer page, Integer perPage);

    /**
     * Get a list of topics in a group forum.
     */
    Topics topics(String groupId, Integer page, Integer perPage);
}
