package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.vimeo.api.model.UploadSpace;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 8:07 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class QuotaMixin {

    @JsonCreator
    protected QuotaMixin(
            @JsonProperty("id")
            String id,
            @JsonProperty("is_plus")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean plus,
            @JsonProperty("upload_space")
            UploadSpace uploadSpace,
            @JsonProperty("hd_quota")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean hdQuota,
            @JsonProperty("sd_quota")
            @JsonDeserialize(using = BooleanJsonDeserializer.class)
            Boolean sdQuota
    ) {
    }
}
