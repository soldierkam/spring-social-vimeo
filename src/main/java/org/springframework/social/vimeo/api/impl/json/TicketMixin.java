package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 9:25 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketMixin {

    @JsonCreator
    public TicketMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("host")
            String host,
            @JsonProperty("endpoint")
            URL endpoint,
            @JsonProperty("max_file_size")
            Long maxFileSize
    ) {
    }
}
