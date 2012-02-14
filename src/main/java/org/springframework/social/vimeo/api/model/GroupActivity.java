package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:40 PM
 */
public class GroupActivity {

    private Integer id;
    private String name;
    private URL image;
    private List<URL> urls;

    protected GroupActivity(Integer id, String name, URL image, List<URL> urls) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.urls = urls;
    }

    public Integer getId() {
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
