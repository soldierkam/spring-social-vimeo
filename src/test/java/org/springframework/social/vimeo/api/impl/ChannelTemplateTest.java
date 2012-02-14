package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.*;
import org.springframework.util.CollectionUtils;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/8/12
 * Time: 10:34 PM
 */
public class ChannelTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testModerated() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_moderated"), responseHeaders));

        ChannelInfos channels = vimeo.channelOperations().moderated("sencha", null, null, null);
        assertEquals(1, channels.getOnThisPage().intValue());
        assertEquals(1, channels.getPage().intValue());
        for (Channel m : channels.getChannels()) {
            assertNotNull(m.getId());
            assertNotNull(m.getImage());
            assertNotNull(m.getName());
            assertFalse(CollectionUtils.isEmpty(m.getUrls()));
        }
    }

    @Test
    public void testModerators() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_moderators"), responseHeaders));

        Moderators moderators = vimeo.channelOperations().moderators("sencha", null, null);
        assertEquals(1, moderators.getOnThisPage().intValue());
        assertEquals(1, moderators.getPage().intValue());
        for (Moderator m : moderators.getModerators()) {
            assertNotNull(m.getCreator());
            assertFalse(CollectionUtils.isEmpty(m.getPortraits()));
        }
    }

    @Test
    public void testVideos() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_videos"), responseHeaders));

        Videos videos = vimeo.channelOperations().videos("sencha", null, null);
        assertEquals(16, videos.getOnThisPage().intValue());
        assertEquals(1, videos.getPage().intValue());
        for (Video video : videos.getVideos()) {
            assertNotNull(video.getAllowAdds());
            assertFalse(CollectionUtils.isEmpty(video.getThumbnails()));
        }
    }

    @Test
    public void testAll() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_all"), responseHeaders));

        Channels channels = vimeo.channelOperations().all("sencha", null, null, null);
        assertEquals(50, channels.getOnThisPage().intValue());
        assertEquals(1, channels.getPage().intValue());
        for (Channel channel : channels.getChannels()) {
            assertNotNull(channel.getId());
            assertFalse(CollectionUtils.isEmpty(channel.getUrls()));
        }
    }

    @Test
    public void testSubscribers() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_subscribers"), responseHeaders));

        People people = vimeo.channelOperations().subscribers("sencha", null, null);
        assertEquals(50, people.getOnThisPage().intValue());
        assertEquals(1, people.getPage().intValue());
        for (ProPerson person : people.getMembers()) {
            assertNotNull(person.getId());
            assertFalse(CollectionUtils.isEmpty(person.getPortraits()));
        }
    }

    @Test
    public void testInfo() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("channel_info"), responseHeaders));

        ChannelInfo channelInfo = vimeo.channelOperations().info("sencha");
        assertNotNull(channelInfo.getId());
        assertFalse(CollectionUtils.isEmpty(channelInfo.getUrls()));
    }
}
