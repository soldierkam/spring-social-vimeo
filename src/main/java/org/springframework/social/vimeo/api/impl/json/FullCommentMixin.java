package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.CommentType;
import org.springframework.social.vimeo.api.model.ProPerson;

import java.net.URL;
import java.util.Date;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 03:46
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FullCommentMixin {

    @JsonCreator
    protected FullCommentMixin(
            @JsonProperty("id")
            Integer id,
            @JsonProperty("text")
            String content,
            @JsonProperty("datecreate")
            Date createDate,
            @JsonProperty("permalink")
            URL permalink,
            @JsonProperty("reply_to_comment_id")
            Integer replyToCommentId,
            @JsonProperty("type")
            @JsonDeserialize(using = CommentTypeJsonDeserializer.class)
            CommentType type,
            @JsonProperty("author")
            ProPerson author
    ) {
    }
}
