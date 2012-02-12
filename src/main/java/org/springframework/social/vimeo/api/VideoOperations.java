package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.*;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:47 PM
 */
public interface VideoOperations {

    /**
     * Search for videos.
     */
    Videos search(String query, Integer page, Integer perPage, VideosSortMethod sortBy, String userId);

    /**
     * Get the cast members of a video.
     */
    Casts cast(String videoId, Integer page, Integer perPage);

    /**
     * Add a specified user as a cast member to the video.
     */
    void addCast(String videoId, String userId, String role);

    /**
     * Remove a cast member from a video.
     */
    void removeCast(String videoId, String userId);

    /**
     * Remove all of the tags from a video.
     */
    void clearTags(String videoId);

    /**
     * Remove a tag from a video.
     */
    void removeTag(String videoId, String tagId);

    /**
     * Add tags to a video.
     */
    void addTags(String videoId, List<String> tags);

    /**
     * Get a list of videos that a user appears in.
     */
    Videos appearsIn(String userId, Integer page, Integer perPage, VideosSortMethod sortBy);

    /**
     * Get all the Albums, Channels and Groups a video is a member of.
     */
    List<Collection> getCollections(String videoId);

    /**
     * Get the URLs of a video's thumbnails.
     */
    List<Image> thumbnails(String videoId);

    /**
     * Get a list of videos that the user likes.
     */
    Videos likes(String userId, Integer page, Integer perPage, VideosSortMethod sortBy);

    /**
     * Get a list of the users that have liked a video.
     */
    Moderators likers(String videoId, Integer page, Integer perPage);

    /**
     * Get a list of videos uploaded by a user.
     */
    Videos uploaded(String userId, Integer page, Integer perPage, VideosSortMethod sortBy);

    /**
     * Set the Creative Commons license on a video.
     */
    void changeLicense(String videoId, CreativeCommonLicenseType licenseType);

    /**
     * Sets the title of a video, overwriting the previous title.
     */
    void changeTitle(String videoId, String title);

    /**
     * Add Flickr photos to a video.
     */
    void addPhotos(String videoId, List<URL> photoUrls);

    /**
     * Permanently delete a video.
     */
    void delete(String videoId);

    /**
     * Get a list of the subscribed videos for a user.
     */
    Videos subscriptions(String userId, Integer page, Integer perPage);

    /**
     * Get lots of information on a video.
     */
    Video info(String videoId);

    /**
     * Get a list of videos that have the specified tag.
     */
    Videos findByTag(String tag, Integer page, Integer perPage, VideosSortMethod sortBy);

    /**
     * Set whether or not the user likes a video.
     */
    void changeLike(String videoId, boolean like);

    /**
     * Set the description for a video, overwriting the previous description.
     */
    void changeDescription(String videoId, String description);

    /**
     * Set the privacy of a video. The possible privacy settings are anybody, nobody, contacts, users, password, or disable.
     */
    void changePrivacy(String videoId, Privacy privacy, String password, List<String> users);

    /**
     * Set the download privacy of a video.
     */
    void changeDownloadPrivacy(String videoId, Boolean allowDownlaod);

    /**
     * Get all videos credited to a user (both uploaded and appears).
     */
    Videos videos(String userId, Integer page, Integer perPage, VideosSortMethod sortBy);
}
