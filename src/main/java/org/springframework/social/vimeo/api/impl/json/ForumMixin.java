package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.ForumThread;

import java.net.URL;

/**
 * User: soldier
 * Date: 11.02.12
 * Time: 23:56
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class ForumMixin {

    @JsonCreator
    protected ForumMixin(
            @JsonProperty(value = "name")
            String name,
            @JsonProperty(value = "url")
            URL url,
            @JsonProperty(value = "thread")
            ForumThread thread
    ) {
    }
}
