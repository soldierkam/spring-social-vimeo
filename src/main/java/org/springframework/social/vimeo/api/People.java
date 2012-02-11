package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/6/12
 * Time: 8:00 PM
 */
public class People extends Paging {
    private List<Person> members;

    public People(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Person> members) {
        super(onThisPage, page, perPage, total);
        this.members = members;
    }

    public List<Person> getMembers() {
        return members;
    }
}
