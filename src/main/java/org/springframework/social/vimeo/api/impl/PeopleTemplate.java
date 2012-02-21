package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.PeopleOperations;
import org.springframework.social.vimeo.api.model.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 21:58
 */
class PeopleTemplate extends AbstractVimeoTemplate implements PeopleOperations {

    private final static VimeoMethod INFO = new VimeoMethodImpl("vimeo.people.getInfo", "person");
    private final static VimeoMethod ADD_CONTACT = new VimeoMethodImpl("vimeo.people.addContact");
    private final static VimeoMethod REMOVE_CONTACT = new VimeoMethodImpl("vimeo.people.removeContact");
    private final static VimeoMethod ADD_SUBSCRIPTION = new VimeoMethodImpl("vimeo.people.addSubscription");
    private final static VimeoMethod GET_PORTRAIT_URLS = new VimeoMethodImpl("vimeo.people.getPortraitUrls", "portraits");
    private final static VimeoMethod REMOVE_SUBSCRIPTION = new VimeoMethodImpl("vimeo.people.removeSubscription");
    private final static VimeoMethod FIND = new VimeoMethodImpl("vimeo.people.findByEmail", "user");
    private final static VimeoMethod SUBSCRIPTIONS = new VimeoMethodImpl("vimeo.people.getSubscriptions", "subscriptions");


    PeopleTemplate(RestTemplate restTemplate, ObjectMapper mapper, boolean authorized) {
        super(restTemplate, mapper, authorized);
    }

    @Override
    public User info(String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("user_id", userId);
        return getObject(INFO, params.build(), User.class);
    }

    @Override
    public void addContact(String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        doMethod(ADD_CONTACT, params.build());
    }

    @Override
    public void removeContact(String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        doMethod(REMOVE_CONTACT, params.build());
    }

    @Override
    public void addSubscription(String userId, List<SubscriptionType> type) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.add("type", type);
        doMethod(ADD_SUBSCRIPTION, params.build());
    }

    @Override
    public void removeSubscription(String userId, List<SubscriptionType> type) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.add("type", type);
        doMethod(REMOVE_SUBSCRIPTION, params.build());
    }

    @Override
    public List<Portrait> getPortraits(String userId) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        return getObjects(GET_PORTRAIT_URLS, params.build(), Portrait.class);
    }

    @Override
    public SimplePerson findByEmail(String email) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("email", email);
        return getObject(FIND, params.build(), SimplePerson.class);
    }

    @Override
    public Subscriptions subscriptions(Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(SUBSCRIPTIONS, params.build(), Subscriptions.class);
    }
}
