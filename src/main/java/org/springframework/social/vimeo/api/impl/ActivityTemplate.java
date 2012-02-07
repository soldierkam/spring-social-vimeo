package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.Activities;
import org.springframework.social.vimeo.api.ActivityOperations;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:35 PM
 */
public class ActivityTemplate extends AbstractVimeoTemplate implements ActivityOperations {

    private final static VimeoMethod HAPPENED = new VimeoMethodImpl("vimeo.activity.happenedToUser", "activities");
    private final static VimeoMethod DID = new VimeoMethodImpl("vimeo.activity.userDid", "activities");

    public ActivityTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    @Override
    public Activities happenedToUser(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(HAPPENED, params.build(), Activities.class);
    }

    @Override
    public Activities did(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("user_id", userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage);
        return getObject(DID, params.build(), Activities.class);
    }
}