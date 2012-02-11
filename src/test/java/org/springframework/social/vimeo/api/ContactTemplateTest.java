package org.springframework.social.vimeo.api;

import org.junit.Test;
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
        }
    }

    @Test
    public void testMutual() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("contact_mutual"), responseHeaders));

        People people = vimeo.contactOperations().mutual("12312", null, null);
        assertEquals(5, people.getOnThisPage().intValue());
        assertEquals(1, people.getPage().intValue());
        for (Person person : people.getMembers()) {
            assertNotNull(person.getPro());
            assertFalse(CollectionUtils.isEmpty(person.getPortraits()));
        }
    }
}
