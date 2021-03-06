package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.vimeo.api.*;
import org.springframework.social.vimeo.api.impl.json.VimeoModule;
import org.springframework.social.vimeo.api.model.PermissionLevel;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

/**
 * User: soldier
 * Date: 2/3/12
 * Time: 6:04 PM
 */
public class VimeoTemplate extends AbstractOAuth1ApiBinding implements Vimeo {

    private AlbumOperations albumOperations;
    private VideoOperations videoOperations;
    private ActivityOperations activityOperations;
    private ChannelOperations channelOperations;
    private ContactOperations contactOperations;
    private UploadOperations uploadOperations;
    private GroupOperations groupOperations;
    private PeopleOperations peopleOperations;
    private OAuthOperations authOperations;
    private ObjectMapper objectMapper;
    private Permission permission;

    public VimeoTemplate() {
        super();
        initSubApis();
    }

    public VimeoTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        initSubApis();
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new VimeoErrorHandler(objectMapper));
    }

    private void initSubApis() {
        permission = new Permission(PermissionLevel.READ);
        setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        getRestTemplate().getMessageConverters().add(new StreamHttpMessageConverter());

        albumOperations = new AlbumTemplate(getRestTemplate(), objectMapper, permission);
        videoOperations = new VideoTemplate(getRestTemplate(), objectMapper, permission);
        activityOperations = new ActivityTemplate(getRestTemplate(), objectMapper, permission);
        channelOperations = new ChannelTemplate(getRestTemplate(), objectMapper, permission);
        contactOperations = new ContactTemplate(getRestTemplate(), objectMapper, permission);
        uploadOperations = new UploadTemplate(getRestTemplate(), objectMapper, permission);
        groupOperations = new GroupTemplate(getRestTemplate(), objectMapper, permission);
        peopleOperations = new PeopleTemplate(getRestTemplate(), objectMapper, permission);
        authOperations = new OAuthTemplate(getRestTemplate(), objectMapper, permission);
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
    public OAuthOperations authOperations() {
        return authOperations;
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
