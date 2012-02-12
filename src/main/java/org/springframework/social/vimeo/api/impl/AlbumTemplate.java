package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.AlbumOperations;
import org.springframework.social.vimeo.api.model.Albums;
import org.springframework.social.vimeo.api.model.AlbumsSortMethod;
import org.springframework.social.vimeo.api.model.Videos;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:12 PM
 */
class AlbumTemplate extends AbstractVimeoTemplate implements AlbumOperations {

    private final static VimeoMethod WATCH_LATER_LIST = new VimeoMethodImpl("vimeo.albums.getWatchLater", "videos");
    private final static VimeoMethod WATCH_LATER_ADD = new VimeoMethodImpl("vimeo.albums.addToWatchLater");
    private final static VimeoMethod WATCH_LATER_REMOVE = new VimeoMethodImpl("vimeo.albums.removeFromWatchLater");
    private final static VimeoMethod DELETE = new VimeoMethodImpl("vimeo.albums.delete");
    private final static VimeoMethod CREATE = new VimeoMethodImpl("vimeo.albums.create", "album");
    private final static VimeoMethod DESCRIPTION = new VimeoMethodImpl("vimeo.albums.setDescription");
    private final static VimeoMethod TITLE = new VimeoMethodImpl("vimeo.albums.setTitle");
    private final static VimeoMethod PASSWD = new VimeoMethodImpl("vimeo.albums.setPassword");
    private final static VimeoMethod LIST = new VimeoMethodImpl("vimeo.albums.getAll", "albums");
    private final static VimeoMethod VIDEO_ADD = new VimeoMethodImpl("vimeo.albums.addVideo");
    private final static VimeoMethod VIDEO_DETACH = new VimeoMethodImpl("vimeo.albums.removeVideo");
    private final static VimeoMethod VIDEO_LIST = new VimeoMethodImpl("vimeo.albums.getVideos", "videos");

    public AlbumTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public void addToWatchLater(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        doMethod(WATCH_LATER_ADD, params.build());
    }

    @Override
    public void removerFromWatchLater(String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("video_id", videoId);
        doMethod(WATCH_LATER_REMOVE, params.build());
    }

    @Override
    public Videos watchLater(Integer pageNumber, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("page", pageNumber);
        params.addIfNotNull("per_page", perPage);
        return getObject(WATCH_LATER_LIST, params.build(), Videos.class);
    }

    @Override
    public void deleteAlbum(String albumId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        doMethod(DELETE, params.build());
    }

    @Override
    public String createAlbum(String videoAsAlbumsThumbnail, Collection<String> videosIds, String title, String description) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("description", description);
        params.addIfNotNull("videos", videosIds);
        params.add("title", title);
        params.add("video_id", videoAsAlbumsThumbnail);
        return doAction(CREATE, params.build());
    }

    @Override
    public void changeDescription(String albumId, String description) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        params.add("description", description);
        doMethod(DESCRIPTION, params.build());
    }

    @Override
    public void changeTitle(String albumId, String title) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        params.add("title", title);
        doMethod(TITLE, params.build());
    }

    @Override
    public void changePassword(String albumId, String password) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        params.add("password", password);
        doMethod(PASSWD, params.build());
    }

    @Override
    public Albums all(Integer pageNumber, Integer perPage, String userId, AlbumsSortMethod sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("page", pageNumber);
        params.addIfNotNull("per_page", perPage);
        params.addIfNotNull("sort", sortBy);
        params.add("user_id", userId);
        return getObject(LIST, params.build(), Albums.class);
    }

    @Override
    public void addVideo(String albumId, String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        params.add("videoId", videoId);
        doMethod(VIDEO_ADD, params.build());
    }

    @Override
    public void removeVideo(String albumId, String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("album_id", albumId);
        params.add("videoId", videoId);
        doMethod(VIDEO_DETACH, params.build());
    }

    @Override
    public Videos videos(String albumId, Integer page, Integer perPage, String password) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        params.addIfNotNull("password", password);
        params.add("album_id", albumId);
        return getObject(VIDEO_LIST, params.build(), Videos.class);
    }
}
