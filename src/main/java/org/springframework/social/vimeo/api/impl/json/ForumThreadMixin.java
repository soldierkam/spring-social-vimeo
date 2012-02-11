package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 00:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ForumThreadMixin {
    @JsonCreator

    protected ForumThreadMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("title")
            String title,
            @JsonProperty("url")
            List<URL> urls
    ) {
    }
}
