package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 9:00 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class UploadSpaceMixin {

    @JsonCreator
    protected UploadSpaceMixin(
            @JsonProperty("free")
            Long free,
            @JsonProperty("max")
            @JsonUnwrapped
            Long max,
            @JsonProperty("resets")
            Long resets,
            @JsonProperty("used")
            Long used
    ) {
    }
}
