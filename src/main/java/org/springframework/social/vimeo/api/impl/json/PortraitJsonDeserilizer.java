package org.springframework.social.vimeo.api.impl.json;

import org.springframework.social.vimeo.api.Portrait;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:30 PM
 */
public class PortraitJsonDeserilizer extends AbstractArrayJsonDeserializer<Portrait>{
    public PortraitJsonDeserilizer() {
        super("portrait");
    }
}
