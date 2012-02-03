package org.springframework.social.vimeo.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.social.vimeo.api.impl.VimeoTemplate;
import org.junit.Before;
/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:04 PM
 */
public class AbstractVimeoApiTest {

    protected static final String ACCESS_TOKEN = "someAccessToken";

    protected VimeoTemplate vimeo;
    protected VimeoTemplate unauthorizedVimeo;
    protected MockRestServiceServer mockServer;
    protected HttpHeaders responseHeaders;

    @Before
    public void setup() {
        vimeo = new VimeoTemplate(ACCESS_TOKEN);
        mockServer = MockRestServiceServer.createServer(vimeo.getRestTemplate());
        responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        unauthorizedVimeo = new VimeoTemplate();
        MockRestServiceServer.createServer(unauthorizedVimeo.getRestTemplate());
    }

}
