package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.Activity;

import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:19 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ActivitiesMixin {

    @JsonCreator
    public ActivitiesMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer pageNumber,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("activity")
            List<Activity> activities
    ) {
    }
}
