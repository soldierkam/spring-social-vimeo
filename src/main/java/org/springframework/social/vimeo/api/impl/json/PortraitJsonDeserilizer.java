package org.springframework.social.vimeo.api.impl.json;

import org.springframework.social.vimeo.api.model.Portrait;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:30 PM
 */
class PortraitJsonDeserilizer extends AbstractArrayJsonDeserializer<Portrait> {
    public PortraitJsonDeserilizer() {
        super("portrait");
    }
}
