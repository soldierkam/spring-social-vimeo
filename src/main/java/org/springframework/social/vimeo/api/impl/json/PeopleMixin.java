package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.vimeo.api.model.Person;

import java.util.List;

/**
 * User: soldier
 * Date: 2/6/12
 * Time: 8:01 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PeopleMixin {

    @JsonCreator
    protected PeopleMixin(
            @JsonProperty(value = "on_this_page")
            Integer onThisPage,
            @JsonProperty(value = "page")
            Integer page,
            @JsonProperty(value = "perpage")
            Integer perPage,
            @JsonProperty(value = "total")
            Integer total,
            @JsonProperty(value = "member")
            List<Person> members) {
    }

    @JsonProperty(value = "subscriber")
    List<Person> members;

}
