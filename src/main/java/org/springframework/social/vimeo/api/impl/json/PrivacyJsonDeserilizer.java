package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.Privacy;

import java.io.IOException;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 9:13 PM
 */
class PrivacyJsonDeserilizer extends JsonDeserializer<Privacy> {
    @Override
    public Privacy deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return Privacy.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read privacy", jp.getCurrentLocation(), exc);
        }
    }
}
