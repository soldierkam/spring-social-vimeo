package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:00
 */
public class Subscription {

    private String subjectId;
    private SubscriptionType type;

    protected Subscription(String subjectId, SubscriptionType type) {
        this.subjectId = subjectId;
        this.type = type;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public SubscriptionType getType() {
        return type;
    }
}
