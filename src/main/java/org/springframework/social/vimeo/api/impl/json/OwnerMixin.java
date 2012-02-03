package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.Portrait;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:33 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class OwnerMixin {

    @JsonCreator

    protected OwnerMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("display_name")
            String displayName,
            @JsonProperty("is_plus")
            Boolean plus,
            @JsonProperty("is_pro")
            Boolean pro,
            @JsonProperty("is_staff")
            Boolean staff,
            @JsonProperty("profileurl")
            URL profileUrl,
            @JsonProperty("realname")
            String realName,
            @JsonProperty("username")
            String userName,
            @JsonProperty("videosurl")
            URL videosUrl
    ) {}

    @JsonProperty("portraits")
    @JsonDeserialize(using = PortraitJsonDeserilizer.class)
    List<Portrait> portraits;
}
