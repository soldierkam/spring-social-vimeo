package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 8:09 PM
 */
public class BooleanJsonDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.readValueAs(String.class);
        if("0".equals(value)){
            return Boolean.FALSE;
        }
        if("1".equals(value)){
            return Boolean.TRUE;
        }
        throw new JsonParseException("Unknown boolean value: " + value, jp.getCurrentLocation());
    }
}
