package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:22 PM
 */
public interface ContactOperations {

    /**
     * Get a list of contacts for a specified user.
     */
    Contacts all(String userId, Integer page, Integer perPage, ContactSort sortBy);

    /**
     * Get a list of the users who have added a specific user as a contact.
     */
    Contacts whoAdded(String userId, Integer page, Integer perPage, ContactSort sortBy);

    /**
     * Get a list of the mutual contacts of a specific user.
     */
    People mutual(String userId, Integer page, Integer perPage);

    /**
     * Get a list of the user's contacts who are currently online.
     */
    Contacts online(String userId, Integer page, Integer perPage);
}
