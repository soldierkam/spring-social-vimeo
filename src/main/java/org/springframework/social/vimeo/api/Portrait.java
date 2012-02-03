package org.springframework.social.vimeo.api;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 5:24 PM
 */
public class Portrait extends Image{
    protected Portrait(Integer width, Integer height, URL url) {
        super(width, height, url);
    }
}
