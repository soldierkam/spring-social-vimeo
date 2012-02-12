package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Cast;

import java.util.List;

/**
 * User: soldier
 * Date: 11.02.12
 * Time: 23:38
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CastsMixin {
    @JsonCreator
    protected CastsMixin(
            @JsonProperty("on_this_page")
            Integer onThisPage,
            @JsonProperty("page")
            Integer page,
            @JsonProperty("perpage")
            Integer perPage,
            @JsonProperty("total")
            Integer total,
            @JsonProperty("member")
            List<Cast> casts
    ) {
    }
}
