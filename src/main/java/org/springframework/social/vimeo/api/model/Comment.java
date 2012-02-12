package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:39 PM
 */
public class Comment {
    private Integer id;
    private String content;

    protected Comment(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
