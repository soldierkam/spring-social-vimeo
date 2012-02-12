package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.Activities;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:16 PM
 */
public interface ActivityOperations {
    /**
     * Get a list of activity on a user.
     */
    Activities happenedToUser(String userId, Integer page, Integer perPage);

    /**
     * Get a list of things that a user did.
     */
    Activities did(String userId, Integer page, Integer perPage);
}
