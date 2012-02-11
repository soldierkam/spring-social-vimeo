package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:25 PM
 */
public class Contacts extends Paging {

    public Contacts(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Contact> contacts) {
        super(onThisPage, page, perPage, total);
        this.contacts = contacts;
    }

    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }
}
