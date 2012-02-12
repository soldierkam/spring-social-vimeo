package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.ThumbnailVideo;
import org.springframework.social.vimeo.api.model.VideosSortMethod;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 12:22 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AlbumMixin {

    @JsonCreator
    protected AlbumMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("title")
            String title,
            @JsonProperty("description")
            String description,
            @JsonProperty("create_on")
            Date createOn,
            @JsonProperty("total_videos")
            Integer totalVideos,
            @JsonProperty("url")
            List<URL> urls,
            @JsonProperty("video_sort_method")
            VideosSortMethod sortMethod,
            @JsonProperty("thumbnail_video")
            ThumbnailVideo thumbnail
    ) {
    }
}
