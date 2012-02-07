package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.Thumbnail;

import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:31 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ThumbnailVideoMixin {

    protected ThumbnailVideoMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("owner")
            String ownerId,
            @JsonProperty("title")
            String title,
            @JsonProperty("thumbnails")
            @JsonDeserialize(using = ThumbnailsJsonDeserializer.class)
            List<Thumbnail> thumbnails
    ) {
    }
}