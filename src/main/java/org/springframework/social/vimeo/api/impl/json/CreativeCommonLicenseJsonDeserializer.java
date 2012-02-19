package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.CreativeCommonLicenseType;

import java.io.IOException;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 03:11
 */
public class CreativeCommonLicenseJsonDeserializer extends JsonDeserializer<CreativeCommonLicenseType> {
    @Override
    public CreativeCommonLicenseType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        if ("0".equals(value)) {
            return CreativeCommonLicenseType.NONE;
        }
        try {
            return CreativeCommonLicenseType.valueOf(value.toUpperCase().replaceAll("-", "_"));
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read license type", jp.getCurrentLocation(), exc);
        }
    }
}
