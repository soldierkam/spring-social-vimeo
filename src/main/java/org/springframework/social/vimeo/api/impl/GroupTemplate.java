package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.OperationNotPermittedException;
import org.springframework.social.vimeo.*;
import org.springframework.social.vimeo.api.GroupOperations;
import org.springframework.social.vimeo.api.model.*;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 7:28 PM
 */
class GroupTemplate extends AbstractVimeoTemplate implements GroupOperations {

    private final static VimeoMethod MODERATORS = new VimeoMethodImpl("vimeo.groups.getModerators", "moderators") {
        {
            add(1, GroupNotFoundException.class);
        }
    };
    private final static VimeoMethod ADD_VIDEO = new VimeoMethodImpl("vimeo.groups.addVideo") {
        {
            add(1, GroupNotFoundException.class);
            add(2, UserNotMemberException.class);
            add(3, OperationNotPermittedException.class);
        }
    };
    private final static VimeoMethod JOIN = new VimeoMethodImpl("vimeo.groups.join") {
        {
            add(1, GroupNotFoundException.class);
            add(2, AlreadyMemberException.class);
            add(3, MembershipRestrictedException.class);
        }
    };
    private final static VimeoMethod ADDABLE = new VimeoMethodImpl("vimeo.groups.getAddable", "groups") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod ALL = new VimeoMethodImpl("vimeo.groups.getAll", "groups") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod INFO = new VimeoMethodImpl("vimeo.groups.getInfo", "groups") {
        {
            add(1, GroupNotFoundException.class);
        }
    };
    private final static VimeoMethod LEAVE = new VimeoMethodImpl("vimeo.groups.leave") {
        {
            add(1, GroupNotFoundException.class);
            add(2, UserNotMemberException.class);
        }
    };
    private final static VimeoMethod MEMBERS = new VimeoMethodImpl("vimeo.groups.getMembers", "members") {
        {
            add(1, GroupNotFoundException.class);
        }
    };
    private final static VimeoMethod VIDEOS = new VimeoMethodImpl("vimeo.groups.getVideos", "videos") {
        {
            add(1, GroupNotFoundException.class);
        }
    };
    private final static VimeoMethod REMOVE = new VimeoMethodImpl("vimeo.groups.removeVideo") {
        {
            add(1, GroupNotFoundException.class);
            add(2, UserNotFoundException.class);
            add(3, OperationNotPermittedException.class);
        }
    };
    private final static VimeoMethod COMMENTS = new VimeoMethodImpl("vimeo.groups.getVideoComments") {
        {
            add(1, GroupNotFoundException.class);
            add(4, VideoNotAddedToGroupException.class);
        }
    };
    private final static VimeoMethod TOPIC_COMMENTS = new VimeoMethodImpl("vimeo.groups.forums.getTopicComments", "comments") {
        {
            add(1, GroupNotFoundException.class);
            add(2, TopicNotFoundException.class);
        }
    };
    private final static VimeoMethod TOPICS = new VimeoMethodImpl("vimeo.groups.forums.getTopics", "topics") {
        {
            add(1, GroupNotFoundException.class);
        }
    };

    public GroupTemplate(RestTemplate restTemplate, ObjectMapper mapper, Permission permission) {
        super(restTemplate, mapper, permission);
    }

    @Override
    public GroupModerators moderators(String groupId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
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
        params.addUser(userId);
        params.addIfNotNull("sort", sort);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(ADDABLE, params.build(), Groups.class);
    }

    @Override
    public Groups all(String userId, VideoCollectionSortMethod sort, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addUser(userId);
        params.addIfNotNull("sort", sort);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(ALL, params.build(), Groups.class);
    }

    @Override
    public Group info(String groupId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        Groups groups = getObject(INFO, params.build(), Groups.class);
        return groups.getGroups().get(0);
    }

    @Override
    public void leave(String groupId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        doMethod(LEAVE, params.build());
    }

    @Override
    public People members(String groupId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        return getObject(MEMBERS, params.build(), People.class);
    }

    @Override
    public Videos videos(String groupId, VideosInGroupSortMethod sort, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.add("full_response", "1");
        params.addIfNotNull("sort", sort);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(VIDEOS, params.build(), Videos.class);
    }

    @Override
    public void removeVideo(String groupId, String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.add("video_id", videoId);
        doMethod(REMOVE, params.build());
    }

    @Override
    public FullComments videoComments(String groupId, String videoId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.add("video_id", videoId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(COMMENTS, params.build(), FullComments.class);
    }

    @Override
    public FullComments topicComments(String groupId, String topicId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.add("topic_id", topicId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(TOPIC_COMMENTS, params.build(), FullComments.class);
    }

    @Override
    public Topics topics(String groupId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("group_id", groupId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(TOPICS, params.build(), Topics.class);
    }
}
