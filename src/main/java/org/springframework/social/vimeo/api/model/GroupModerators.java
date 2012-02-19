package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:39
 */
public class GroupModerators extends Paging {
    private List<ProPerson> moderators;

    protected GroupModerators(Integer onThisPage, Integer page, Integer perPage, Integer total, List<ProPerson> moderators) {
        super(onThisPage, page, perPage, total);
        this.moderators = moderators;
    }

    public List<ProPerson> getModerators() {
        return moderators;
    }
}
