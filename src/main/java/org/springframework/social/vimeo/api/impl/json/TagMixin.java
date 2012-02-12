package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:40 PM
 */
abstract class TagMixin {

    @JsonCreator()
    TagMixin(
            @JsonProperty("author")
            String authorId,
            @JsonProperty("id")
            String id,
            @JsonProperty("normalized")
            String normalized,
            @JsonProperty("url")
            URL url,
            @JsonProperty("_content")
            String content) {
    }
}
