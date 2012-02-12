package org.springframework.social.vimeo.api.model;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 10:25 PM
 */
public class Forum {

    private String name;
    private URL url;
    private ForumThread thread;

    protected Forum(String name, URL url, ForumThread thread) {
        this.name = name;
        this.url = url;
        this.thread = thread;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    public ForumThread getThread() {
        return thread;
    }
}
