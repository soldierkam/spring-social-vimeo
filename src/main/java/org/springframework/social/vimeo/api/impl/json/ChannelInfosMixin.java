package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.ChannelInfo;

import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 15:07
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ChannelInfosMixin {

    @JsonCreator
    protected ChannelInfosMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("channel")
            List<ChannelInfo> channels
    ) {
    }
}
