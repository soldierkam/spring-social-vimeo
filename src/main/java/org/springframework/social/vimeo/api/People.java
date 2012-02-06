package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/6/12
 * Time: 8:00 PM
 */
public class People {
    private Integer total;
    private List<Person> members;

    public People(Integer total, List<Person> members) {
        this.total = total;
        this.members = members;
    }

    public Integer getTotal() {
        return total;
    }

    public List<Person> getMembers() {
        return members;
    }
}
