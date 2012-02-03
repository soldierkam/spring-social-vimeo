package org.springframework.social.vimeo.api;

import java.util.Collection;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:04 PM
 */
public interface AlbumOperations {

    String addToWatchLater(String videoId);

    void removerFromWatchLater(String videoId);

    List<Video> watchLater(Integer pageNumber, Integer perPage);

    void deleteAlbum(String albumId);

    String createAlbum(String videoAsAlbumsThumbnail, Collection<String> videosIds, String title, String description);

    void changeDescription(String albumId, String description);

    void changeTitle(String albumId, String title);

    void changePassword(String albumId, String password);

    List<Album> all(Integer pageNumber, Integer perPage, String userId, AlbumsSortMethod sortBy);

    void addVideo(String albumId, String videoId);

    void removeVideo(String albumId, String videoId);

    List<Video> videos(String albumId, Integer page, Integer perPage, String password);
}
