package org.springframework.social.vimeo.api;

import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 3:01 PM
 */
public interface Vimeo {

    OAuthOperations authOperations();

    AlbumOperations albumOperations();

    VideoOperations videoOperations();

    ActivityOperations activityOperations();

    ChannelOperations channelOperations();

    ContactOperations contactOperations();

    UploadOperations uploadOperations();

    GroupOperations groupOperations();

    PeopleOperations peopleOperations();

    RestTemplate restTemplate();
}
