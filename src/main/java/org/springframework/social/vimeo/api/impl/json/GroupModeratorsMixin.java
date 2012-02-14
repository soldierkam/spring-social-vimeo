package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.GroupModerator;

import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:40
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class GroupModeratorsMixin {

    @JsonCreator
    protected GroupModeratorsMixin(
            @JsonProperty(value = "on_this_page")
            Integer onThisPage,
            @JsonProperty(value = "page")
            Integer page,
            @JsonProperty(value = "perpage")
            Integer perPage,
            @JsonProperty(value = "total")
            Integer total,
            @JsonProperty(value = "moderator")
            List<GroupModerator> moderators
    ) {
    }
}
