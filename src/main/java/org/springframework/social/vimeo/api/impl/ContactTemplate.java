package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.ContactOperations;
import org.springframework.social.vimeo.api.ContactSort;
import org.springframework.social.vimeo.api.Contacts;
import org.springframework.social.vimeo.api.People;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:38 PM
 */
public class ContactTemplate extends AbstractVimeoTemplate implements ContactOperations {

    private final static VimeoMethod ALL = new VimeoMethodImpl("vimeo.contacts.getAll", "contacts");
    private final static VimeoMethod WHO_ADDED = new VimeoMethodImpl("vimeo.contacts.getWhoAdded", "contacts");
    private final static VimeoMethod MUTUAL = new VimeoMethodImpl("vimeo.contacts.getMutual", "contacts");
    private final static VimeoMethod ONLINE = new VimeoMethodImpl("vimeo.contacts.getOnline", "contacts");

    public ContactTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public Contacts all(String userId, Integer page, Integer perPage, ContactSort sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("perpage", perPage);
        params.addIfNotNull("sort", sortBy);
        return getObject(ALL, params.build(), Contacts.class);
    }

    @Override
    public Contacts whoAdded(String userId, Integer page, Integer perPage, ContactSort sortBy) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("perpage", perPage);
        params.addIfNotNull("sort", sortBy);
        return getObject(WHO_ADDED, params.build(), Contacts.class);
    }

    @Override
    public People mutual(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("perpage", perPage);
        return getObject(MUTUAL, params.build(), People.class);
    }

    @Override
    public Contacts online(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("perpage", perPage);
        return getObject(ONLINE, params.build(), Contacts.class);
    }
}
