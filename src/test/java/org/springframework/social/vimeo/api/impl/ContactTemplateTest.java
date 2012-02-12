package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.Contact;
import org.springframework.social.vimeo.api.model.Contacts;
import org.springframework.util.CollectionUtils;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/9/12
 * Time: 6:45 PM
 */
public class ContactTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testAll() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("contact_all"), responseHeaders));

        Contacts contacts = vimeo.contactOperations().all("12312", null, null, null);
        assertEquals(13, contacts.getOnThisPage().intValue());
        assertEquals(1, contacts.getPage().intValue());
        for (Contact contact : contacts.getContacts()) {
            assertNotNull(contact.getMutual());
            assertFalse(CollectionUtils.isEmpty(contact.getPortraits()));
            assertNotNull(contact.getMutual());
        }
    }

    @Test
    public void testMutual() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("contact_mutual"), responseHeaders));

        Contacts contacts = vimeo.contactOperations().mutual("12312", null, null);
        assertEquals(5, contacts.getOnThisPage().intValue());
        assertEquals(1, contacts.getPage().intValue());
        for (Contact contact : contacts.getContacts()) {
            assertNotNull(contact.getPro());
            assertFalse(CollectionUtils.isEmpty(contact.getPortraits()));
        }
    }

    @Test
    public void testWhoAdded() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("contact_who_added"), responseHeaders));

        Contacts contacts = vimeo.contactOperations().whoAdded("12312", null, null, null);
        assertEquals(50, contacts.getOnThisPage().intValue());
        assertEquals(1, contacts.getPage().intValue());
        for (Contact contact : contacts.getContacts()) {
            assertNotNull(contact.getPro());
            assertFalse(CollectionUtils.isEmpty(contact.getPortraits()));
            assertNotNull("Contact " + contact, contact.getMutual());
        }
    }

    @Test
    public void testOnline() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("contact_online"), responseHeaders));

        Contacts contacts = vimeo.contactOperations().online("12312", null, null);
        assertEquals(1, contacts.getOnThisPage().intValue());
        assertEquals(1, contacts.getPage().intValue());
        Contact contact = contacts.getContacts().get(0);
        assertNotNull(contact.getPro());
        assertFalse(CollectionUtils.isEmpty(contact.getPortraits()));
        assertNotNull(contact.getMutual());
    }
}
