package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.impl.AbstractCollection;

import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:18 AM
 */
public class Albums extends AbstractCollection {

    public Albums(Integer onThisPage, Integer pageNumber, Integer perPage, Integer total, List<Album> albums) {
        super(onThisPage, pageNumber, perPage, total);
        this.albums = albums;
    }

    private List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }
}
