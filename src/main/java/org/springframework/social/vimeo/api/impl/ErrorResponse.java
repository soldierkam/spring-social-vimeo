package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:46 PM
 */
public class ErrorResponse extends VimeoResponse{

    @JsonProperty("err")
    private Error error;
}
