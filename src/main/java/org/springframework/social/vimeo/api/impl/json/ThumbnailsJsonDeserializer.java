package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.vimeo.api.model.Image;

import java.util.List;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:22 PM
 */
class ThumbnailsJsonDeserializer extends AbstractArrayJsonDeserializer<Image> {
    public ThumbnailsJsonDeserializer() {
        super("thumbnail");
    }

    @Override
    protected TypeReference refType() {
        return new TypeReference<List<Image>>() {};
    }
}
