package org.springframework.social.vimeo.api;

import org.junit.Test;
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
}
