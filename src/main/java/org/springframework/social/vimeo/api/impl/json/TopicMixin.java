package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.Person;

import java.util.Date;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 03:22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TopicMixin {
    protected TopicMixin(
            @JsonProperty("created_on")
            Date createdOn,
            @JsonProperty("id")
            Integer id,
            @JsonProperty("locked")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean locked,
            @JsonProperty("name")
            String name,
            @JsonProperty("sticky")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean sticky,
            @JsonProperty("creator")
            Person creator
    ) {
    }
}
