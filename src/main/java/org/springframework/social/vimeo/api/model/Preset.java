package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 01:13
 */
public class Preset {
    private Integer id;
    private String name;

    protected Preset(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
