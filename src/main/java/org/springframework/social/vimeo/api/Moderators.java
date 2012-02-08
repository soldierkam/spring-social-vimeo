package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:36 PM
 */
public class Moderators extends Paging {
    private List<Moderator> moderators;

    protected Moderators(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Moderator> moderators) {
        super(onThisPage, page, perPage, total);
        this.moderators = moderators;
    }

    public List<Moderator> getModerators() {
        return moderators;
    }
}
