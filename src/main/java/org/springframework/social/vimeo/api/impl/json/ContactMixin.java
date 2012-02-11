package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:19 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ContactMixin {

    @JsonCreator
    protected ContactMixin(
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
            @JsonProperty("mutual")
            //@JsonProperty("is_mutual_contact")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean mutual
    ) {
    }

}
