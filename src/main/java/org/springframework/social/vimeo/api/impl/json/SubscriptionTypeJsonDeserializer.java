package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.SubscriptionType;

import java.io.IOException;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 21:13
 */
public class SubscriptionTypeJsonDeserializer extends JsonDeserializer<SubscriptionType> {
    @Override
    public SubscriptionType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return SubscriptionType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read subscription type", jp.getCurrentLocation(), exc);
        }
    }
}
