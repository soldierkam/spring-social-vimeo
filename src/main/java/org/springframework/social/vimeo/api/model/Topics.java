package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 17.02.12
 * Time: 00:06
 */
public class Topics extends Paging {
    private List<Topic> topics;

    public Topics(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Topic> topics) {
        super(onThisPage, page, perPage, total);
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
