package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Channel;

import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 7:54 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ChannelsMixin {

    @JsonCreator
    protected ChannelsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("channel")
            List<Channel> channels) {
    }
}
