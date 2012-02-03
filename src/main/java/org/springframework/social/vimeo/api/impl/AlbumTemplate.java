package org.springframework.social.vimeo.api.impl;

import org.springframework.social.vimeo.api.Album;
import org.springframework.social.vimeo.api.AlbumOperations;
import org.springframework.social.vimeo.api.AlbumsSortMethod;
import org.springframework.social.vimeo.api.Video;

import java.util.Collection;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:12 PM
 */
public class AlbumTemplate implements AlbumOperations{
    @Override
    public String addToWatchLater(String videoId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removerFromWatchLater(String videoId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Video> watchLater(Integer pageNumber, Integer perPage) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteAlbum(String albumId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String createAlbum(String videoAsAlbumsThumbnail, Collection<String> videosIds, String title, String description) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void changeDescription(String albumId, String description) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void changeTitle(String albumId, String title) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void changePassword(String albumId, String password) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Album> all(Integer pageNumber, Integer perPage, String userId, AlbumsSortMethod sortBy) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addVideo(String albumId, String videoId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeVideo(String albumId, String videoId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Video> videos(String albumId, Integer page, Integer perPage, String password) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
