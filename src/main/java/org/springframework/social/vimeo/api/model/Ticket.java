package org.springframework.social.vimeo.api.model;

import java.net.URL;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 9:24 AM
 */
public class Ticket {
    private String id;
    private String host;
    private URL endpoint;
    private Long maxFileSize;

    protected Ticket(String id, String host, URL endpoint, Long maxFileSize) {
        this.id = id;
        this.host = host;
        this.endpoint = endpoint;
        this.maxFileSize = maxFileSize;
    }

    public String getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public URL getEndpoint() {
        return endpoint;
    }

    public Long getMaxFileSize() {
        return maxFileSize;
    }
}
