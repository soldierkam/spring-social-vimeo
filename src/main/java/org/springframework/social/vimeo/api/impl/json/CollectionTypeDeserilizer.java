package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.CollectionType;

import java.io.IOException;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 4:23 PM
 */
class CollectionTypeDeserilizer extends JsonDeserializer<CollectionType> {
    @Override
    public CollectionType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return CollectionType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read collection type", jp.getCurrentLocation(), exc);
        }
    }
}
