package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 19:19
 */
public class FullComments extends Paging {
    private List<FullComment> comments;

    protected FullComments(Integer onThisPage, Integer page, Integer perPage, Integer total, List<FullComment> comments) {
        super(onThisPage, page, perPage, total);
        this.comments = comments;
    }

    public List<FullComment> getComments() {
        return comments;
    }
}
