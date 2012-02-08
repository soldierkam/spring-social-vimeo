package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.Moderator;

import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:35 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ModeratorsMixin {

    @JsonCreator
    protected ModeratorsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("user")
            List<Moderator> moderators
    ) {
    }
}
