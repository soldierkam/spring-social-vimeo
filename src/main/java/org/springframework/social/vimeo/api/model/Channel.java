package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 10:27 PM
 */
public class Channel {

    private String id;
    private String name;
    private URL image;
    private List<URL> urls;

    protected Channel(String id, String name, URL image, List<URL> urls) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public URL getImage() {
        return image;
    }

    public List<URL> getUrls() {
        return urls;
    }
}
