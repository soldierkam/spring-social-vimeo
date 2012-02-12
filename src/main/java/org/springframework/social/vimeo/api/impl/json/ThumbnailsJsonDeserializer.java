package org.springframework.social.vimeo.api.impl.json;

import org.springframework.social.vimeo.api.model.Image;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:22 PM
 */
class ThumbnailsJsonDeserializer extends AbstractArrayJsonDeserializer<Image> {
    public ThumbnailsJsonDeserializer() {
        super("thumbnail");
    }
}
