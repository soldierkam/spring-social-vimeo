package org.springframework.social.vimeo.api;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import static org.junit.Assert.*;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 5:55 PM
 */
public class VideoTemplateTest extends AbstractVimeoApiTest{

    @Test
    public void testSearch(){
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("video_search"), responseHeaders));

        Videos videos = vimeo.videoOperations().search("sencha", null, null, null, null);
        assertEquals(50, videos.getOnThisPage().intValue());
        assertEquals(1, videos.getPageNumber().intValue());
        for(Video v : videos.getVideos()){
            assertNotNull(v.getModifiedDate());
        }
    }
}
