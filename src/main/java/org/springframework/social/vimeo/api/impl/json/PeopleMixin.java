package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.Person;

import java.util.List;

/**
 * User: soldier
 * Date: 2/6/12
 * Time: 8:01 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class PeopleMixin {

    protected PeopleMixin(
            @JsonProperty(value = "total")
            Integer total,
            @JsonProperty(value = "member")
            List<Person> members) {
    }
}
