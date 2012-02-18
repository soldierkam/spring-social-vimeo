package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 19:19
 */
public class Comments extends Paging {
    private List<Comment> comments;

    public Comments(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Comment> comments) {
        super(onThisPage, page, perPage, total);
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
