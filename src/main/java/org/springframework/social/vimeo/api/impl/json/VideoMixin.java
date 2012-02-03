package org.springframework.social.vimeo.api.impl.json;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.Image;
import org.springframework.social.vimeo.api.Owner;


/**
 * User: soldier
 * Date: 2/3/12
 * Time: 4:11 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class VideoMixin {

    @JsonCreator
    VideoMixin(@JsonProperty("allow_adds")
            Boolean allowAdds,
               @JsonProperty("embed_privacy")
               String embedPrivacy,
               @JsonProperty("id")
               String id,
               @JsonProperty("is_hd")
               Boolean hd,
               @JsonProperty("is_transcoding")
               Boolean transcoding,
               @JsonProperty("license")
               String license,
               @JsonProperty("privacy")
               String privacy,
               @JsonProperty("title")
               String title,
               @JsonProperty("description")
               String description,
               @JsonProperty("upload_date")
               Date uploadDate,
               @JsonProperty("modified_date")
               Date modifiedDate,
               @JsonProperty("number_of_likes")
               Integer numberOfLikes,
               @JsonProperty("number_of_plays")
               Integer numberOfPlays,
               @JsonProperty("number_of_comments")
               Integer numberOfComments,
               @JsonProperty("width")
               Integer width,
               @JsonProperty("height")
               Integer height,
               @JsonProperty("duration")
               Integer duration,
               @JsonProperty("owner")
               Owner owner) {}

    @JsonProperty("thumbnails")
    @JsonDeserialize(using = ThumbnailsJsonDeserializer.class)
    List<Image> thumbnails;

}
