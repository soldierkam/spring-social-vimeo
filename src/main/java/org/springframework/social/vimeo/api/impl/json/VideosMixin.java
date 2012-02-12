package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Video;

import java.util.List;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 6:06 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VideosMixin {
    @JsonCreator
    public VideosMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer pageNumber,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("video")
            List<Video> videos
    ) {
    }
}
