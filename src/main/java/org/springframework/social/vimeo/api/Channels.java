package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 7:53 PM
 */
public class Channels extends Paging {

    private List<Channel> channels;

    public Channels(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Channel> channels) {
        super(onThisPage, page, perPage, total);
        this.channels = channels;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
