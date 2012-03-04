package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.ApiException;
import org.springframework.social.vimeo.api.ActivityOperations;
import org.springframework.social.vimeo.api.model.Activities;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:35 PM
 */
class ActivityTemplate extends AbstractVimeoTemplate implements ActivityOperations {

    private final static VimeoMethod HAPPENED = new VimeoMethodImpl("vimeo.activity.happenedToUser", "activities") {
        {
            //User not found
            add(1, ApiException.class);//The user id or name was either not valid or not provided.
        }
    };
    private final static VimeoMethod DID = new VimeoMethodImpl("vimeo.activity.userDid", "activities") {
        {
            //User not found
            add(1, ApiException.class);//The user id or name was either not valid or not provided.
        }
    };

    public ActivityTemplate(RestTemplate restTemplate, ObjectMapper mapper, Permission permission) {
        super(restTemplate, mapper, permission);
    }

    @Override
    public Activities happenedToUser(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addUser(userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(HAPPENED, params.build(), Activities.class);
    }

    @Override
    public Activities did(String userId, Integer page, Integer perPage) {
        ParamsBuilder params = new ParamsBuilder();
        params.addUser(userId);
        params.addIfNotNull("page", page);
        params.addIfNotNull("per_page", perPage, 50);
        return getObject(DID, params.build(), Activities.class);
    }
}
