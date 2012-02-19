package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.OperationNotPermittedException;
import org.springframework.social.vimeo.*;
import org.springframework.social.vimeo.api.VideoOperations;
import org.springframework.social.vimeo.api.model.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:13 PM
 */
class VideoTemplate extends AbstractVimeoTemplate implements VideoOperations {

    private final static VimeoMethod SEARCH_METHOD = new VimeoMethodImpl("vimeo.videos.search", "videos") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod ADD_CAST = new VimeoMethodImpl("vimeo.videos.addCast") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod REMOVE_CAST = new VimeoMethodImpl("vimeo.videos.removeCast") {
        {
            add(1, UserNotFoundException.class);
            add(2, UserNotInCastException.class);
            add(3, OwnerCannotDoThisException.class);
        }
    };
    private final static VimeoMethod CAST = new VimeoMethodImpl("vimeo.videos.getCast", "cast") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod CLEAR_TAGS = new VimeoMethodImpl("vimeo.videos.clearTags") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod REMOVE_TAG = new VimeoMethodImpl("vimeo.videos.removeTag") {
        {
            add(1, VideoNotFoundException.class);
            add(2, TagNotFoundException.class);
        }
    };
    private final static VimeoMethod ADD_TAGS = new VimeoMethodImpl("vimeo.videos.addTags") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod APPEARS_IN = new VimeoMethodImpl("vimeo.videos.getAppearsIn") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod COLLECTIONS = new VimeoMethodImpl("vimeo.videos.getCollections", "collection") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod LIKES = new VimeoMethodImpl("vimeo.videos.getLikes") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod LIKERS = new VimeoMethodImpl("vimeo.videos.getLikers") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod UPLOADED = new VimeoMethodImpl("vimeo.videos.getUploaded") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod CHANGE_LICENSE = new VimeoMethodImpl("vimeo.videos.setLicense") {
        {
            add(1, VideoNotFoundException.class);
            add(2, InvalidLicenseException.class);
        }
    };
    private final static VimeoMethod CHANGE_TITLE = new VimeoMethodImpl("vimeo.videos.setTitle") {
        {
            add(1, VideoNotFoundException.class);
            add(2, BlankTitleException.class);
        }
    };
    private final static VimeoMethod ADD_PHOTOS = new VimeoMethodImpl("vimeo.videos.addPhotos") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod DELETE = new VimeoMethodImpl("vimeo.videos.delete") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod SUBSCRIPTIONS = new VimeoMethodImpl("vimeo.videos.getSubscriptions") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod INFO = new VimeoMethodImpl("vimeo.videos.getInfo") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod THUMBNAILS = new VimeoMethodImpl("vimeo.videos.getThumbnailUrls", "thumbnails") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod FIND_BY_TAG = new VimeoMethodImpl("vimeo.videos.getByTag");
    private final static VimeoMethod CHANGE_LIKE = new VimeoMethodImpl("vimeo.videos.setLike") {
        {
            add(1, VideoNotFoundException.class);
            add(2, OwnerCannotDoThisException.class);
        }
    };
    private final static VimeoMethod CHANGE_DESCRIPTION = new VimeoMethodImpl("vimeo.videos.setDescription") {
        {
            add(1, VideoNotFoundException.class);
            add(2, BlankDescriptionException.class);
        }
    };
    private final static VimeoMethod CHANGE_PRIVACY = new VimeoMethodImpl("vimeo.videos.setPrivacy") {
        {
            add(1, VideoNotFoundException.class);
            add(2, UserNotPlusException.class);
        }
    };
    private final static VimeoMethod CHANGE_DOWNLOAD_PRIVACY = new VimeoMethodImpl("vimeo.videos.setDownloadPrivacy") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod USERS_VIDEOS = new VimeoMethodImpl("vimeo.videos.getAll") {
        {
            add(1, UserNotFoundException.class);
        }
    };
    private final static VimeoMethod DELETE_COMMENT = new VimeoMethodImpl("vimeo.videos.comments.deleteComment") {
        {
            add(1, UserNotFoundException.class);
            add(2, CommentNotFoundException.class);
        }
    };
    private final static VimeoMethod EDIT_COMMENT = new VimeoMethodImpl("vimeo.videos.comments.editComment") {
        {
            add(1, UserNotFoundException.class);
            add(2, CommentNotFoundException.class);
            add(3, BlankCommentException.class);
        }
    };
    private final static VimeoMethod LIST_COMMENT = new VimeoMethodImpl("vimeo.videos.comments.getList", "comment") {
        {
            add(1, VideoNotFoundException.class);
        }
    };
    private final static VimeoMethod ADD_COMMENT = new VimeoMethodImpl("vimeo.videos.comments.addComment") {
        {
            add(1, VideoNotFoundException.class);
            add(2, OperationNotPermittedException.class);
            add(3, BlankCommentException.class);
        }
    };

    private final static VimeoMethod GET_PRESETS = new VimeoMethodImpl("vimeo.videos.embed.getPresets", "preset") {
        {
            add(2, UserNotPlusException.class);
        }
    };

    private final static VimeoMethod SET_PRESET = new VimeoMethodImpl("vimeo.videos.embed.setPreset") {
        {
            add(1, VideoNotFoundException.class);
            add(2, UserNotPlusException.class);
            add(3, InvalidEmbedPresetException.class);
        }
    };

    public VideoTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public Videos search(String query, Integer page, Integer perPage, VideosSortMethod sortBy, String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("full_response", "1");
        params.add("query", query);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        params.addIfNotNull("userId", userId);
        return getObject(SEARCH_METHOD, params.build(), Videos.class);
    }

    @Override
    public void addCast(String videoId, String userId, String role) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("user_id", userId);
        params.addIfNotNull("role", role);
        doMethod(ADD_CAST, params.build());
    }

    @Override
    public void clearTags(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        doMethod(CLEAR_TAGS, params.build());
    }

    @Override
    public Videos appearsIn(String userId, Integer page, Integer perPage, VideosSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("full_response", "1");
        params.add("userId", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        return getObject(APPEARS_IN, params.build(), Videos.class);
    }

    @Override
    public List<Collection> getCollections(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        return getObjects(COLLECTIONS, params.build(), Collection.class);
    }

    @Override
    public Videos likes(String userId, Integer page, Integer perPage, VideosSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("full_response", "1");
        params.add("userId", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        return getObject(LIKES, params.build(), Videos.class);
    }

    @Override
    public Videos uploaded(String userId, Integer page, Integer perPage, VideosSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("full_response", "1");
        params.add("userId", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        return getObject(UPLOADED, params.build(), Videos.class);
    }

    @Override
    public void changeLicense(String videoId, CreativeCommonLicenseType licenseType) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        if (CreativeCommonLicenseType.NONE.equals(licenseType)) {
            params.add("license", "0");
        } else {
            params.add("license", licenseType);
        }
        doMethod(CHANGE_LICENSE, params.build());
    }

    @Override
    public void changeTitle(String videoId, String title) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("title", title);
        doMethod(CHANGE_TITLE, params.build());
    }

    @Override
    public void addPhotos(String videoId, List<URL> photoUrls) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("photo_urls", photoUrls);
        doMethod(ADD_PHOTOS, params.build());
    }

    @Override
    public void delete(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        doMethod(DELETE, params.build());
    }

    @Override
    public Videos subscriptions(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("userId", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(SUBSCRIPTIONS, params.build(), Videos.class);
    }

    @Override
    public Video info(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("videoId", videoId);
        return getObject(INFO, params.build(), Video.class);
    }

    @Override
    public Videos findByTag(String tag, Integer page, Integer perPage, VideosSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("tag", tag);
        params.add("full_response", "1");
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        return getObject(FIND_BY_TAG, params.build(), Videos.class);
    }

    @Override
    public void changeLike(String videoId, boolean like) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("like", like);
        doMethod(CHANGE_LIKE, params.build());
    }

    @Override
    public void changeDescription(String videoId, String description) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("description", description);
        doMethod(CHANGE_DESCRIPTION, params.build());

    }

    @Override
    public void removeCast(String videoId, String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("user_id", userId);
        doMethod(REMOVE_CAST, params.build());
    }

    @Override
    public void addTags(String videoId, List<String> tags) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("tag", tags);
        doMethod(ADD_TAGS, params.build());
    }

    @Override
    public Videos videos(String userId, Integer page, Integer perPage, VideosSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        params.addIfNotNull("sort", sortBy);
        return getObject(USERS_VIDEOS, params.build(), Videos.class);
    }

    @Override
    public Casts cast(String videoId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(CAST, params.build(), Casts.class);
    }

    @Override
    public Moderators likers(String videoId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(LIKERS, params.build(), Moderators.class);
    }

    @Override
    public void changePrivacy(String videoId, Privacy privacy, String password, List<String> users) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("privacy", privacy);
        params.addIfNotNull("password", password);
        params.addIfNotNull("users", users);
        doMethod(CHANGE_PRIVACY, params.build());
    }

    @Override
    public void changeDownloadPrivacy(String videoId, Boolean allowDownlaod) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("download", allowDownlaod);
        doMethod(CHANGE_DOWNLOAD_PRIVACY, params.build());
    }

    @Override
    public void removeTag(String videoId, String tagId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("tag_id", tagId);
        doMethod(REMOVE_TAG, params.build());
    }

    @Override
    public List<Image> thumbnails(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        return getObjects(THUMBNAILS, params.build(), Image.class);
    }

    @Override
    public void editComment(String videoId, String commentId, String text) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("comment_id", commentId);
        params.add("comment_text", text);
        doMethod(EDIT_COMMENT, params.build());
    }

    @Override
    public void deleteComment(String videoId, String commentId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("comment_id", commentId);
        doMethod(DELETE_COMMENT, params.build());
    }

    @Override
    public FullComments videoComment(String videoId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("page", page);
        params.add("per_page", perPage);
        return getObject(LIST_COMMENT, params.build(), FullComments.class);
    }

    @Override
    public String addComment(String videoId, String replyToCommentId, String text) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.addIfNotNull("reply_to_comment_id", replyToCommentId);
        params.add("comment_text", text);
        return doAction(ADD_COMMENT, params.build());
    }

    @Override
    public void changePreset(String videoId, Integer presetId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        params.add("preset_id", presetId);
        doMethod(SET_PRESET, params.build());
    }

    @Override
    public Presets presets(Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(GET_PRESETS, params.build(), Presets.class);
    }
}
