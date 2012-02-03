package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:38 PM
 */
abstract public class ImageMixin {

    @JsonCreator()
    ImageMixin(
            @JsonProperty("width")
            Integer width,
            @JsonProperty("height")
            Integer height,
            @JsonProperty("_content")
            URL url) {}
}
