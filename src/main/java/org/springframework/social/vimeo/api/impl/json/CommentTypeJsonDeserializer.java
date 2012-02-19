package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.vimeo.api.model.CommentType;

import java.io.IOException;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 03:53
 */
public class CommentTypeJsonDeserializer extends JsonDeserializer<CommentType> {
    @Override
    public CommentType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        try {
            return CommentType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException exc) {
            throw new JsonParseException("Cannot read comment type", jp.getCurrentLocation(), exc);
        }
    }
}
