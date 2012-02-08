package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.*;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 7:51 PM
 */
public class ChannelTemplate extends AbstractVimeoTemplate implements ChannelOperations {

    private final static VimeoMethod ADD_VIDEO = new VimeoMethodImpl("vimeo.channels.addVideo");
    private final static VimeoMethod REMOVE_VIDEO = new VimeoMethodImpl("vimeo.channels.removeVideo");
    private final static VimeoMethod MODERATED = new VimeoMethodImpl("vimeo.channels.getModerated", "channels");
    private final static VimeoMethod MODERATORS = new VimeoMethodImpl("vimeo.channels.getModerators", "moderators");
    private final static VimeoMethod VIDEOS = new VimeoMethodImpl("vimeo.channels.getVideos", "videos");
    private final static VimeoMethod UNSUBSCRIBE = new VimeoMethodImpl("vimeo.channels.unsubscribe");
    private final static VimeoMethod SUBSCRIBE = new VimeoMethodImpl("vimeo.channels.subscribe");
    private final static VimeoMethod SUBSCRIBERS = new VimeoMethodImpl("vimeo.channels.getSubscribers", "user");
    private final static VimeoMethod ALL = new VimeoMethodImpl("vimeo.channels.getAll", "channels");
    private final static VimeoMethod INFO = new VimeoMethodImpl("vimeo.channels.getInfo", "channel");

    public ChannelTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public void addVideo(String channelId, Long videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        params.add("video_id", videoId);
        doMethod(ADD_VIDEO, params.build());
    }

    @Override
    public Channels moderated(String userId, Integer page, Integer perPage, ChannelSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        params.addIfNotNull("sort", sortBy);
        return getObject(MODERATED, params.build(), Channels.class);
    }

    @Override
    public Videos videos(String channelId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        params.add("full_response", "1");
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(VIDEOS, params.build(), Videos.class);
    }

    @Override
    public void unsubscribe(String channelId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        doMethod(UNSUBSCRIBE, params.build());
    }

    @Override
    public Channels all(String userId, Integer page, Integer perPage, ChannelSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        params.addIfNotNull("sort", sortBy);
        return getObject(ALL, params.build(), Channels.class);
    }

    @Override
    public void subscribe(String channelId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        doMethod(SUBSCRIBE, params.build());
    }

    @Override
    public People subscribers(String channelId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(SUBSCRIBERS, params.build(), People.class);
    }

    @Override
    public ChannelInfo info(String channelId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        return getObject(INFO, params.build(), ChannelInfo.class);
    }

    @Override
    public void removeVideo(String channelId, Long videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        params.add("video_id", videoId);
        doMethod(REMOVE_VIDEO, params.build());
    }

    @Override
    public Moderators moderators(String channelId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("channel_id", channelId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(MODERATORS, params.build(), Moderators.class);
    }
}
