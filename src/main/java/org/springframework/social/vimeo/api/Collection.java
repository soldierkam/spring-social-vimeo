package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/5/12
 * Time: 4:13 PM
 */
public class Collection {

    private String id;
    private String name;
    private CollectionType type;

    public Collection(String id, String name, CollectionType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CollectionType getType() {
        return type;
    }
}
