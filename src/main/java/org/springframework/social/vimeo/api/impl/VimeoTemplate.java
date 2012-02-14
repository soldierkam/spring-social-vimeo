package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.vimeo.api.*;
import org.springframework.social.vimeo.api.impl.json.VimeoModule;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:04 PM
 */
class VimeoTemplate extends AbstractOAuth1ApiBinding implements Vimeo {

    private AlbumOperations albumOperations;
    private VideoOperations videoOperations;
    private ActivityOperations activityOperations;
    private ChannelOperations channelOperations;
    private ContactOperations contactOperations;
    private UploadOperations uploadOperations;
    private GroupOperations groupOperations;
    private PeopleOperations peopleOperations;
    private ObjectMapper objectMapper;

    public VimeoTemplate() {
        super();
        initSubApis();
    }

    public VimeoTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        initSubApis();
    }

    private void initSubApis() {
        getRestTemplate().getMessageConverters().add(new StreamHttpMessageConverter());
        getRestTemplate().setErrorHandler(new VimeoErrorHandler(objectMapper));
        albumOperations = new AlbumTemplate(getRestTemplate(), objectMapper);
        videoOperations = new VideoTemplate(getRestTemplate(), objectMapper);
        activityOperations = new ActivityTemplate(getRestTemplate(), objectMapper);
        channelOperations = new ChannelTemplate(getRestTemplate(), objectMapper);
        contactOperations = new ContactTemplate(getRestTemplate(), objectMapper);
        uploadOperations = new UploadTemplate(getRestTemplate(), objectMapper);
        groupOperations = new GroupTemplate(getRestTemplate(), objectMapper);
        peopleOperations = new PeopleTemplate(getRestTemplate(), objectMapper);
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
    public ActivityOperations activityOperations() {
        return activityOperations;
    }

    @Override
    public ChannelOperations channelOperations() {
        return channelOperations;
    }

    @Override
    public RestTemplate restTemplate() {
        return getRestTemplate();
    }

    @Override
    public ContactOperations contactOperations() {
        return contactOperations;
    }

    @Override
    public UploadOperations uploadOperations() {
        return uploadOperations;
    }

    @Override
    public GroupOperations groupOperations() {
        return groupOperations;
    }

    @Override
    public PeopleOperations peopleOperations() {
        return peopleOperations;
    }

    @Override
    protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
        MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.registerModule(new VimeoModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
