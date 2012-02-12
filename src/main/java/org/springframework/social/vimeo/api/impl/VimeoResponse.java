package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:43 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class VimeoResponse {

    @JsonProperty("generated_in")
    private Integer generateIn;
    @JsonProperty("stat")
    private VimeoResponseType stat;

    public Integer getGenerateIn() {
        return generateIn;
    }

    public VimeoResponseType getStat() {
        return stat;
    }
}
