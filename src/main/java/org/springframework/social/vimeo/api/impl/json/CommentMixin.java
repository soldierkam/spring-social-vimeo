package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:44 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentMixin {

    @JsonCreator
    public CommentMixin(
            @JsonProperty("id")
            Integer id,
            @JsonProperty("_content")
            String content
    ) {
    }
}
