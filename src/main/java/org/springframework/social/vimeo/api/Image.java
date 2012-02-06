package org.springframework.social.vimeo.api;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 4:00 PM
 */
public class Image {
    
    private Integer width;
    private Integer height;
    private URL url;

    protected Image(Integer width, Integer height, URL url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public URL getUrl() {
        return url;
    }
}
