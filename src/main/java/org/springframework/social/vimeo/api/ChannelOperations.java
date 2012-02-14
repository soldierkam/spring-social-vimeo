package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.*;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 7:45 PM
 */
public interface ChannelOperations {

    /**
     * Add a video to a channel.
     * You can only add a video to a channel if you're the moderator of that channel.
     */
    void addVideo(String channelId, Long videoId);

    /**
     * Remove a video from a channel.
     */
    void removeVideo(String channelId, Long videoId);

    /**
     * Get a list of the channels that a user moderates.
     */
    ChannelInfos moderated(String userId, Integer page, Integer perPage, VideoCollectionSortMethod sortBy);

    /**
     * Get a list of the channel's moderators.
     */
    Moderators moderators(String channelId, Integer page, Integer perPage);

    /**
     * Get a list of the videos in a channel.
     */
    Videos videos(String channelId, Integer page, Integer perPage);

    /**
     * Unsubscribe a user from a channel.
     */
    void unsubscribe(String channelId);

    /**
     * Subscribe a user to a channel.
     */
    void subscribe(String channelId);

    /**
     * Get a list of all public channels.
     */
    Channels all(String userId, Integer page, Integer perPage, VideoCollectionSortMethod sortBy);

    /**
     * Get a list of the channel's subscribers.
     */
    People subscribers(String channelId, Integer page, Integer perPage);

    /**
     * Get the information on a single channel.
     */
    ChannelInfo info(String channelId);

}
