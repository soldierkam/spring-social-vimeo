package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.Subscription;
import org.springframework.social.vimeo.api.model.Subscriptions;
import org.springframework.social.vimeo.api.model.User;
import org.springframework.util.CollectionUtils;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 12.02.12
 * Time: 22:03
 */
public class PeopleTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testInfo() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("people_info"), responseHeaders));

        User user = vimeo.peopleOperations().info("sencha");
        assertEquals(1276092249000l, user.getCreatedOn().getTime());
        assertEquals("4012687", user.getId());
        assertEquals(Boolean.FALSE, user.getContact());
        assertEquals(Boolean.FALSE, user.getPlus());
        assertEquals(Boolean.FALSE, user.getStaff());
        assertEquals(Boolean.FALSE, user.getSubscribedTo());
        assertEquals("sencha", user.getUsername());
        assertEquals("Sencha", user.getDisplayName());
        assertEquals("Redwood City,CA", user.getLocation());
        assertEquals("http://sencha.com", user.getUrl().get(0).toString());
        assertEquals("Sencha makes JavaScript frameworks to develop amazing web apps built on web standards. Check out Ext JS and Sencha Touch.", user.getBiography());
        assertEquals(Integer.valueOf(0), user.getContacts());
        assertEquals(Integer.valueOf(160), user.getUploads());
        assertEquals(Integer.valueOf(0), user.getLikes());
        assertEquals(Integer.valueOf(160), user.getVideos());
        assertEquals(Integer.valueOf(0), user.getVideosAppearsIn());
        assertEquals(Integer.valueOf(3), user.getAlbums());
        assertEquals(Integer.valueOf(1), user.getChannels());
        assertEquals(Integer.valueOf(0), user.getGroups());
        assertEquals("http://vimeo.com/sencha", user.getProfileUrl().toString());
        assertEquals("http://vimeo.com/sencha/videos", user.getVideosUrl().toString());
        assertFalse(CollectionUtils.isEmpty(user.getPortraits()));
    }

    @Test
    public void testSubscriptions() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("people_subscriptions"), responseHeaders));

        Subscriptions subscriptions = vimeo.peopleOperations().subscriptions(null, null);
        assertEquals(3, subscriptions.getOnThisPage().intValue());
        for (Subscription subscription : subscriptions.getSubscriptions()) {
            assertNotNull(subscription.getSubjectId());
            assertNotNull(subscription.getType());
        }
    }

}
