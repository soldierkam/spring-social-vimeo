package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.vimeo.api.Image;

import java.io.IOException;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:27 PM
 */
public class AbstractArrayJsonDeserializer<T> extends JsonDeserializer<List<T>>{

    private final String fieldName;

    protected AbstractArrayJsonDeserializer(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public List<T> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDeserializationConfig(ctxt.getConfig());
        jp.setCodec(mapper);
        if(jp.hasCurrentToken()) {
            JsonNode dataNode = jp.readValueAsTree().get(fieldName);
            if(dataNode != null) {
                return (List<T>) mapper.readValue(dataNode, new TypeReference<List<T>>() {});
            }
        }

        return null;
    }
}
