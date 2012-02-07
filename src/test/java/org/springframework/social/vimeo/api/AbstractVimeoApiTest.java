package org.springframework.social.vimeo.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.social.vimeo.api.impl.VimeoTemplate;
import org.junit.Before;

import java.io.IOException;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:04 PM
 */
public class AbstractVimeoApiTest {

    protected static final String CONSUMER_KEY = "cons_key";
    protected static final String CONSUMER_SECRET = "cons_secret";
    protected static final String ACCESS_TOKEN = "access_token";
    protected static final String ACCESS_TOKEN_SECRET = "access_token_secret";

    protected VimeoTemplate vimeo;
    protected VimeoTemplate unauthorizedVimeo;
    protected MockRestServiceServer mockServer;
    protected HttpHeaders responseHeaders;

    @Before
    public void setup() {
        vimeo = new VimeoTemplate(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
        mockServer = MockRestServiceServer.createServer(vimeo.getRestTemplate());
        responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        unauthorizedVimeo = new VimeoTemplate();
        MockRestServiceServer.createServer(unauthorizedVimeo.getRestTemplate());
    }

    protected Resource jsonResource(String filename) {
        ClassPathResource resource = new ClassPathResource("testdata/" + filename + ".json", getClass());
        if(!resource.exists() || !resource.isReadable()){
            try{
                throw new IllegalArgumentException("Missing resource: " + resource.getURI());
            }catch (IOException e){
                throw new IllegalArgumentException("Missing resource", e);
            }
        }
        return resource;
    }

}