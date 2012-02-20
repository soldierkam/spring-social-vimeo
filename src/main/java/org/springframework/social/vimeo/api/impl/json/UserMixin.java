package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.Portrait;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 21:51
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserMixin {

    @JsonCreator
    protected UserMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("display_name")
            String displayName,
            @JsonProperty("is_plus")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean plus,
            @JsonProperty("is_staff")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean staff,
            @JsonProperty("profileurl")
            URL profileUrl,
            @JsonProperty("realname")
            String realName,
            @JsonProperty("username")
            String userName,
            @JsonProperty("videosurl")
            URL videosUrl,
            @JsonProperty("created_on")
            Date createdOn,
            @JsonProperty("is_contact")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean contact,
            @JsonProperty("is_subscribed_to")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean subscribedTo,
            @JsonProperty("location")
            String location,
            @JsonProperty("url")
            List<URL> url,
            @JsonProperty("bio")
            String biography,
            @JsonProperty("number_of_contacts")
            Integer contacts,
            @JsonProperty("number_of_uploads")
            Integer uploads,
            @JsonProperty("number_of_likes")
            Integer likes,
            @JsonProperty("number_of_videos")
            Integer videos,
            @JsonProperty("number_of_videos_appears_in")
            Integer videosAppearsIn,
            @JsonProperty("number_of_albums")
            Integer albums,
            @JsonProperty("number_of_channels")
            Integer channels,
            @JsonProperty("number_of_groups")
            Integer groups,
            @JsonProperty("portraits")
            @JsonDeserialize(using = PortraitJsonDeserilizer.class)
            List<Portrait> portraits
    ) {
    }


}
