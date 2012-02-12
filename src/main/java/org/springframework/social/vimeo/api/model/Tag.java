package org.springframework.social.vimeo.api.model;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 4:07 PM
 */
public class Tag {

    private String authorId;
    private String id;
    private String normalized;
    private URL url;
    private String content;

    protected Tag(String authorId, String id, String normalized, URL url, String content) {
        this.authorId = authorId;
        this.id = id;
        this.normalized = normalized;
        this.url = url;
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getId() {
        return id;
    }

    public String getNormalized() {
        return normalized;
    }

    public URL getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }
}
