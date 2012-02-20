package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.vimeo.api.model.Portrait;

import java.io.IOException;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:30 PM
 */
class PortraitJsonDeserilizer extends AbstractArrayJsonDeserializer<Portrait> {
    public PortraitJsonDeserilizer() {
        super("portrait");
    }

    @Override
    protected TypeReference refType() {
        return new TypeReference<List<Portrait>>() {};
    }
}
