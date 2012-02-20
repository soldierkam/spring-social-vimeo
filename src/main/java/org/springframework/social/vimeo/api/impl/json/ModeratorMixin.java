package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.Portrait;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:28 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ModeratorMixin {

    @JsonCreator
    protected ModeratorMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("display_name")
            String displayName,
            @JsonProperty("is_plus")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean plus,
            @JsonProperty("is_pro")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean pro,
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
            @JsonProperty("portraits")
            @JsonDeserialize(using = PortraitJsonDeserilizer.class)
            List<Portrait> portraits
    ) {
    }

    @JsonProperty("is_creator")
    @JsonDeserialize(using = BooleanJsonDeserializer.class)
    private Boolean creator;
}
