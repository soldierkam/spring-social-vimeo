package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.Albums;
import org.springframework.social.vimeo.api.model.AlbumsSortMethod;
import org.springframework.social.vimeo.api.model.Videos;

import java.util.Collection;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:04 PM
 */
//TODO: videoId should be Long
public interface AlbumOperations {

    void addToWatchLater(String videoId);

    void removerFromWatchLater(String videoId);

    Videos watchLater(Integer pageNumber, Integer perPage);

    void deleteAlbum(String albumId);

    String createAlbum(String videoAsAlbumsThumbnail, Collection<String> videosIds, String title, String description);

    void changeDescription(String albumId, String description);

    void changeTitle(String albumId, String title);

    void changePassword(String albumId, String password);

    Albums all(Integer pageNumber, Integer perPage, String userId, AlbumsSortMethod sortBy);

    void addVideo(String albumId, String videoId);

    void removeVideo(String albumId, String videoId);

    Videos videos(String albumId, Integer page, Integer perPage, String password);
}
