package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 15:04
 */
public class ChannelInfos extends Paging {
    private List<ChannelInfo> channels;

    public ChannelInfos(Integer onThisPage, Integer page, Integer perPage, Integer total, List<ChannelInfo> channels) {
        super(onThisPage, page, perPage, total);
        this.channels = channels;
    }

    public List<ChannelInfo> getChannels() {
        return channels;
    }
}
