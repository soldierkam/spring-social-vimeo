package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 7:41 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ChannelMixin {

    @JsonCreator
    public ChannelMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("name")
            String name,
            @JsonProperty("image")
            URL image,
            @JsonProperty("url")
            List<URL> urls
    ) {
    }
}
