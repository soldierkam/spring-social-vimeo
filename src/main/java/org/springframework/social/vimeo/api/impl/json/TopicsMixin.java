package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Topic;

import java.util.List;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 03:24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TopicsMixin {

    @JsonCreator
    protected TopicsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("topic")
            List<Topic> topics
    ) {
    }
}
