package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.Calendar;
import org.springframework.social.vimeo.api.model.Permissions;
import org.springframework.social.vimeo.api.model.Person;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class GroupMixin {

    @JsonCreator
    protected GroupMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("is_featured")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean featured,
            @JsonProperty("name")
            String name,
            @JsonProperty("created_on")
            Date createdOn,
            @JsonProperty("modified_on")
            Date modifiedOn,
            @JsonProperty("total_videos")
            Integer totalVideos,
            @JsonProperty("total_members")
            Integer totalMembers,
            @JsonProperty("total_threads")
            Integer totalThreads,
            @JsonProperty("total_files")
            Integer totalFiles,
            @JsonProperty("total_events")
            Integer totalEvents,
            @JsonProperty("url")
            List<URL> url,
            @JsonProperty("permissions")
            Permissions permissions,
            @JsonProperty("calendar")
            Calendar calendar,
            @JsonProperty("creator")
            Person creator
    ) {
    }
}
