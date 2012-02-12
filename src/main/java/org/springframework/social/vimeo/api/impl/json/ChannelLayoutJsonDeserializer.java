package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.ChannelLayout;

import java.io.IOException;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 14:28
 */
class ChannelLayoutJsonDeserializer extends JsonDeserializer<ChannelLayout> {
    @Override
    public ChannelLayout deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return ChannelLayout.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read channel layout", jp.getCurrentLocation(), exc);
        }
    }
}
