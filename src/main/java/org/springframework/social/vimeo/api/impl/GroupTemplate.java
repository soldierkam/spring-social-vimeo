package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.GroupOperations;
import org.springframework.social.vimeo.api.model.GroupModerators;
import org.springframework.social.vimeo.api.model.Groups;
import org.springframework.social.vimeo.api.model.VideoCollectionSortMethod;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 7:28 PM
 */
class GroupTemplate extends AbstractVimeoTemplate implements GroupOperations {

    private final static VimeoMethod MODERATORS = new VimeoMethodImpl("vimeo.groups.getModerators", "moderators");
    private final static VimeoMethod ADD_VIDEO = new VimeoMethodImpl("vimeo.groups.addVideo");
    private final static VimeoMethod JOIN = new VimeoMethodImpl("vimeo.groups.join");
    private final static VimeoMethod ADDABLE = new VimeoMethodImpl("vimeo.groups.getAddable", "groups");
    private final static VimeoMethod ALL = new VimeoMethodImpl("vimeo.groups.getAll", "groups");

    public GroupTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public GroupModerators moderators(String groupId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(MODERATORS, params.build(), GroupModerators.class);
    }

    @Override
    public void addVideo(String groupId, String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.add("video_id", videoId);
        doMethod(ADD_VIDEO, params.build());
    }

    @Override
    public void join(String groupId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        doMethod(JOIN, params.build());
    }

    @Override
    public Groups addable(String userId, VideoCollectionSortMethod sort, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("sort", sort);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(ADDABLE, params.build(), Groups.class);
    }

    @Override
    public Groups all(String userId, VideoCollectionSortMethod sort, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("sort", sort);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(ALL, params.build(), Groups.class);
    }
}
