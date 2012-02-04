package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.Video;

import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:20 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AlbumsMixin {
    @JsonCreator

    public AlbumsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer pageNumber,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("album")
            List<Video> videos
    ) {
    }
}