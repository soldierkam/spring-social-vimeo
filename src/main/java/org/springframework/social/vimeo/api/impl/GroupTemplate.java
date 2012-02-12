package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.GroupOperations;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 7:28 PM
 */
class GroupTemplate extends AbstractVimeoTemplate implements GroupOperations {

    public GroupTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }


}
