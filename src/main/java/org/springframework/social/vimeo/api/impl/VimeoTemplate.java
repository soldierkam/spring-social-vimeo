package org.springframework.social.vimeo.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.vimeo.api.AlbumOperations;
import org.springframework.social.vimeo.api.VideoOperations;
import org.springframework.social.vimeo.api.Vimeo;
import org.springframework.web.client.RestTemplate;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:04 PM
 */
public class VimeoTemplate extends AbstractOAuth2ApiBinding implements Vimeo{

    private AlbumOperations albumOperations;
    private VideoOperations videoOperations;

    public VimeoTemplate() {
        initSubApis();
    }

    public VimeoTemplate(String accessToken) {
        super(accessToken);
                      initSubApis();
    }

    private void initSubApis(){
        albumOperations = new AlbumTemplate();
        videoOperations = new VideoTemplate();
    }

    @Override
    public AlbumOperations albumOperations() {
        return albumOperations;
    }

    @Override
    public VideoOperations videoOperations() {
        return videoOperations;
    }

    @Override
    public RestTemplate restTemplate() {
        return getRestTemplate();
    }
}
