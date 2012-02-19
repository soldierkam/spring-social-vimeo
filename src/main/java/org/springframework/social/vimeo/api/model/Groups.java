package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:03
 */
public class Groups extends Paging {

    private List<Group> groups;

    protected Groups(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Group> groups) {
        super(onThisPage, page, perPage, total);
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
