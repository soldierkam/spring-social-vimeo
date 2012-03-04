package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.Quota;
import org.springframework.social.vimeo.api.model.Ticket;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.headerContains;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 8:17 AM
 */
public class UploadTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testGetQuota() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("upload_quota"), responseHeaders));

        Quota quota = vimeo.uploadOperations().quota();
        assertEquals("101193", quota.getId());
        assertEquals(Boolean.TRUE, quota.getHdQuota());
        assertEquals(Boolean.TRUE, quota.getSdQuota());
        assertEquals(Boolean.TRUE, quota.getPlus());
        assertEquals(Long.valueOf(1073741824l), quota.getUploadSpace().getFree());
        assertEquals(Long.valueOf(5368709120l), quota.getUploadSpace().getMax());
        assertEquals(Long.valueOf(3l), quota.getUploadSpace().getResets());
        assertEquals(Long.valueOf(0l), quota.getUploadSpace().getUsed());
    }

    @Test
    public void testGetTicket() throws MalformedURLException {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("upload_ticket"), responseHeaders));

        Ticket ticket = vimeo.uploadOperations().ticket(null, null);
        assertEquals("a5e0ef1b0a5730efea859a3f8d009a2e", ticket.getId());
        assertEquals("50.16.67.230", ticket.getHost());
        assertEquals(new URL("http://50.16.67.230/upload_multi?ticket_id=a5e0ef1b0a5730efea859a3f8d009a2e"), ticket.getEndpoint());
        assertEquals(Long.valueOf(524288000l), ticket.getMaxFileSize());
    }
}
