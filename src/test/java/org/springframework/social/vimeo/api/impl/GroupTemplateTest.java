package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.Groups;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:23
 */
public class GroupTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testAll() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_all"), responseHeaders));

        Groups groups = vimeo.groupOperations().all("12345", null, null, null);
        assertEquals(50, groups.getOnThisPage().intValue());
        //TODO: check more!
    }
}
