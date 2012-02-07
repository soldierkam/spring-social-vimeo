package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.*;

import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:11 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ActivityMixin {

    @JsonCreator
    protected ActivityMixin(
            @JsonProperty("id")
            Integer id,
            @JsonProperty("type")
            @JsonDeserialize(using = ActivityTypeJsonDeseriializer.class)
            ActivityType type,
            @JsonProperty("time")
            Date time,
            @JsonProperty("active_user")
            Person user,
            @JsonProperty("video")
            List<Video> video,
            @JsonProperty("comment")
            List<Comment> comment,
            @JsonProperty("group")
            Group group
    ) {
    }
}
