package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 9:10 PM
 */
public class StreamingUploaderTest extends AbstractVimeoApiTest {

    @Test
    public void testUpload() throws IOException {
        //quota
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("upload_quota"), responseHeaders));

        //ticket
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("upload_ticket"), responseHeaders));

        //upload
        mockServer.expect(requestTo("http://1.2.3.4/upload?ticket_id=abcdef124567890"))
                .andExpect(method(PUT))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(videoResource("video.mp4"), responseHeaders));

        //get size
        responseHeaders.set("Range", "bytes=0-10");
        mockServer.expect(requestTo("http://1.2.3.4/upload?ticket_id=abcdef124567890"))
                .andExpect(method(PUT))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andExpect(headerContains("Content-Range", "bytes */*"))
                .andRespond(withResponse("", responseHeaders));

        //complete
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("upload_complete"), responseHeaders));
        ;

        ClassPathResource videoResource = videoResource("video.mp4");

        StreamingUploaderImpl streamingUploader = (StreamingUploaderImpl) vimeo.uploadOperations().upload("video/mp4", null);
        streamingUploader.send(videoResource.getFile());

    }

    private ClassPathResource videoResource(String filename) {
        return new ClassPathResource("../videos/" + filename, getClass());
    }
}
