package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.ActivityType;

import java.io.IOException;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 10:08 PM
 */
public class ActivityTypeJsonDeseriializer extends JsonDeserializer<ActivityType> {
    @Override
    public ActivityType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return ActivityType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read activity type", jp.getCurrentLocation(), exc);
        }
    }
}
