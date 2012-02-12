package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:46 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ErrorResponse extends VimeoResponse {

    private final Error error;

    @JsonCreator
    ErrorResponse(@JsonProperty("err") Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
