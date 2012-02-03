package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.vimeo.api.Image;
import org.springframework.social.vimeo.api.Thumbnail;

import java.io.IOException;
import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:22 PM
 */
public class ThumbnailsJsonDeserializer extends AbstractArrayJsonDeserializer<Thumbnail> {
    public ThumbnailsJsonDeserializer() {
        super("thumbnail");
    }
}
