package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.ChannelLayout;
import org.springframework.social.vimeo.api.model.Privacy;
import org.springframework.social.vimeo.api.model.ProPerson;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:01 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ChannelInfoMixin {

    @JsonCreator
    protected ChannelInfoMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("is_featured")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean featured,
            @JsonProperty("is_sponsored")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean sponsored,
            @JsonProperty("is_subscribed")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean subscribed,
            @JsonProperty("name")
            String name,
            @JsonProperty("description")
            String description,
            @JsonProperty("created_on")
            Date createdOn,
            @JsonProperty("modified_on")
            Date modifiedOn,
            @JsonProperty("total_videos")
            Integer totalVideos,
            @JsonProperty("total_subscribers")
            Integer totalSubscribers,
            @JsonProperty("logo_url")
            URL logoUrl,
            @JsonProperty("badge_url")
            URL badgeUrl,
            @JsonProperty("thumbnail_url")
            URL thumbnailUrl,
            @JsonProperty("url")
            List<URL> urls,
            @JsonProperty("layout")
            @JsonDeserialize(using = ChannelLayoutJsonDeserializer.class)
            ChannelLayout layout,
            @JsonProperty("theme")
            String theme,
            @JsonProperty("privacy")
            @JsonDeserialize(using = PrivacyJsonDeserilizer.class)
            Privacy privacy,
            @JsonProperty("creator")
            ProPerson creator
    ) {
    }
}
