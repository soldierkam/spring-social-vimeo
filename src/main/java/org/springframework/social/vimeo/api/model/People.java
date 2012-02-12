package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 2/6/12
 * Time: 8:00 PM
 */
public class People extends Paging {
    private List<Person> members;

    protected People(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Person> members) {
        super(onThisPage, page, perPage, total);
        this.members = members;
    }

    protected People(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Person> members, Integer i) {
        super(onThisPage, page, perPage, total);
        this.members = members;
    }

    protected People(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Person> members, String i) {
        super(onThisPage, page, perPage, total);
        this.members = members;
    }

    public List<Person> getMembers() {
        return members;
    }
}
