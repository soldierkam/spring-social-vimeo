package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:47 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Error {
    private final Integer code;
    private final String expl;
    private final String msg;

    @JsonCreator
    Error(
            @JsonProperty("code")
            Integer code,
            @JsonProperty("expl")
            String expl,
            @JsonProperty("msg")
            String msg) {
        this.code = code;
        this.expl = expl;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getExpl() {
        return expl;
    }

    public String getMsg() {
        return msg;
    }
}
