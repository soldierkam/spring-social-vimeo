package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CalendarMixin {
    @JsonCreator
    public CalendarMixin(
            @JsonProperty(value = "type")
            String type
    ) {
    }
}
