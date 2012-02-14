package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.SubscriptionType;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:03
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SubscriptionMixin {

    @JsonCreator
    public SubscriptionMixin(
            @JsonProperty("subject_id")
            String subjectId,
            @JsonProperty("type")
            @JsonDeserialize(using = SubscriptionTypeJsonDeserializer.class)
            SubscriptionType type
    ) {
    }
}

