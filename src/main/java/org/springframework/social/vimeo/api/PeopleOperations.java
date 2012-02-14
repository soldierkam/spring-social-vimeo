package org.springframework.social.vimeo.api;

import org.springframework.social.vimeo.api.model.*;

import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 21:30
 */
public interface PeopleOperations {

    /**
     * Get information about a user.
     */
    User info(String userId);

    /**
     * Add the specified user as a contact.
     */
    void addContact(String userId);

    /**
     * Remove a person from the user's contacts.
     */
    void removeContact(String userId);

    /**
     * Subscribe to the specified user's videos.
     * Use this to subscribe to a user's "likes", "appears", or "uploads".
     * This won't remove subscriptions, you must call removeSubscription to do that.
     */
    void addSubscription(String userId, List<SubscriptionType> type);

    /**
     * Unsubscribe from a user's videos.
     */
    void removeSubscription(String userId, List<SubscriptionType> type);

    /**
     * Get a list of the user's portraits.
     */
    List<Portrait> getPortraits(String userId);

    /**
     * Find a user by their email address.
     */
    SimplePerson findByEmail(String email);

    /**
     * Get a list of the things a user is subscribed to.
     */
    Subscriptions subscriptions(Integer page, Integer perPage);

}
