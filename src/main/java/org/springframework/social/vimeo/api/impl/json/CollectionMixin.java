package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.CollectionType;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 4:17 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class CollectionMixin {
    protected CollectionMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("name")
            String name,
            @JsonProperty("type")
            @JsonDeserialize(using = CollectionTypeDeserilizer.class)
            CollectionType type
    ) {
    }
}
