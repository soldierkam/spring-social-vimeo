package org.springframework.social.vimeo.api.model;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 6:15 PM
 */
public class Chunk {
    private String id;
    private Long size;

    protected Chunk(String id, Long size) {
        this.id = id;
        this.size = size;
    }
}
