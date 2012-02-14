package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 20:52
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SimplePersonMixin {
    @JsonCreator
    protected SimplePersonMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("username")
            String username,
            @JsonProperty("display_name")
            String displayName) {
    }
}
