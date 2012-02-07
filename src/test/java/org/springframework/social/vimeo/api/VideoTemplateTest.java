package org.springframework.social.vimeo.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 5:55 PM
 */
public class VideoTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testSearch() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("video_search"), responseHeaders));

        Videos videos = vimeo.videoOperations().search("sencha", null, null, null, null);
        assertEquals(50, videos.getOnThisPage().intValue());
        assertEquals(1, videos.getPage().intValue());
        for (Video v : videos.getVideos()) {
            assertNotNull(v.getModifiedDate());
        }
    }

    @Test
    public void testGetThumbnails() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("video_thumbnail"), responseHeaders));

        List<Image> thumbnails = vimeo.videoOperations().thumbnails("12345");
        assertEquals(4, thumbnails.size());
        for (Image thumbnail : thumbnails) {
            assertNotNull(thumbnail.getHeight());
            assertNotNull(thumbnail.getWidth());
            assertNotNull(thumbnail.getUrl());
        }
    }

    @Test
    public void testGetCast() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("video_cast"), responseHeaders));

        People cast = vimeo.videoOperations().cast("12345", null, null);
        assertEquals(Integer.valueOf(1), cast.getTotal());
        Person p = cast.getMembers().get(0);
        assertNotNull(p.getDisplayName());
        assertEquals("3148077", p.getId());
        assertTrue(p.getPlus());
        assertFalse(p.getPro());
        assertFalse(p.getStaff());
    }

    @Test
    public void testGetCast2() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("video_cast2"), responseHeaders));

        People cast = vimeo.videoOperations().cast("12345", null, null);
        assertEquals(Integer.valueOf(2), cast.getTotal());
        for (Person p : cast.getMembers()) {
            assertNotNull(p.getDisplayName());
            assertNotNull(p.getId());
            assertNotNull(p.getPlus());
            assertFalse(p.getPro());
            assertFalse(p.getStaff());
        }
    }
}
