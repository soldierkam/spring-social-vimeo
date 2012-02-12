package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 00:29
 */
public class ForumThread {

    private String id;
    private String title;
    private List<URL> urls;

    protected ForumThread(String id, String title, List<URL> urls) {
        this.id = id;
        this.title = title;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<URL> getUrls() {
        return urls;
    }
}
