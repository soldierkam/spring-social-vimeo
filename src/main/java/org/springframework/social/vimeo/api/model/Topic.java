package org.springframework.social.vimeo.api.model;

import java.util.Date;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 23:59
 */
public class Topic {

    private Date createdOn;
    private Integer id;
    private Boolean locked;
    private String name;
    private Boolean sticky;
    private Person creator;

    public Topic(Date createdOn, Integer id, Boolean locked, String name, Boolean sticky, Person creator) {
        this.createdOn = createdOn;
        this.id = id;
        this.locked = locked;
        this.name = name;
        this.sticky = sticky;
        this.creator = creator;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getLocked() {
        return locked;
    }

    public String getName() {
        return name;
    }

    public Boolean getSticky() {
        return sticky;
    }

    public Person getCreator() {
        return creator;
    }
}
