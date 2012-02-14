package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:00
 */
public class Subscriptions extends Paging {
    private List<Subscription> subscriptions;

    protected Subscriptions(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Subscription> subscriptions) {
        super(onThisPage, page, perPage, total);
        this.subscriptions = subscriptions;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
