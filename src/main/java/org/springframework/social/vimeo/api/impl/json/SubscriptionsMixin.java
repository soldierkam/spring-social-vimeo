package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Subscription;

import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:02
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SubscriptionsMixin {

    @JsonCreator
    public SubscriptionsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("subscription")
            List<Subscription> subscriptions
    ) {
    }
}
