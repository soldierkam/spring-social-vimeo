package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.ApiException;
import org.springframework.social.vimeo.api.model.Activities;
import org.springframework.social.vimeo.api.model.Activity;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:51 PM
 */
public class ActivityTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testHappenedToUser() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("activity_happened"), responseHeaders));

        Activities activities = vimeo.activityOperations().happenedToUser("user1234", null, null);
        assertEquals(22, activities.getTotal().intValue());
        assertEquals(22, activities.getOnThisPage().intValue());
        for (Activity activity : activities.getActivities()) {
            assertNotNull(activity.getId());
            assertNotNull(activity.getTime());
            assertNotNull(activity.getUser());
            assertNotNull(activity.getType());
        }
    }

    @Test(expected = ApiException.class)
    public void testCallHappenedToUserWithInvalidUserId() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("user_not_found"), responseHeaders));

        Activities activities = vimeo.activityOperations().happenedToUser("x_as", null, null);
        fail();
    }

    @Test
    public void testUserDid() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("activity_did"), responseHeaders));

        Activities activities = vimeo.activityOperations().did("user1234", null, null);
        assertEquals(150, activities.getTotal().intValue());
        assertEquals(50, activities.getOnThisPage().intValue());
        for (Activity activity : activities.getActivities()) {
            assertNotNull(activity.getId());
            assertNotNull(activity.getTime());
            assertNotNull(activity.getUser());
            assertNotNull(activity.getType());
        }
    }
}
