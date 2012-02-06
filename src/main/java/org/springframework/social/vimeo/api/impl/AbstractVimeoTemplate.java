package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.social.ApiException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 2:26 PM
 */
public class AbstractVimeoTemplate {

    protected boolean secure = true;
    protected final RestTemplate restTemplate;
    protected final ObjectMapper objectMapper;

    public AbstractVimeoTemplate(RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = mapper;
    }

    protected String getUri(){
        return secure ? "https://vimeo.com/api/rest/v2" : "http://vimeo.com/api/rest/v2";
    }

    protected <T> List<T> getObjects(VimeoMethod method, MultiValueMap<String, Object> p, Class<T> type){
        JsonNode node = restTemplate.getForObject(getUri(), JsonNode.class, createParamsMap(method, p));
        JsonNode data = node.get(method.dataNodeName());
        return deserializeDataList(data, type);
    }
    <T> T getObject(VimeoMethod method, MultiValueMap<String, Object> p, Class<T> type){
        JsonNode node = restTemplate.getForObject(getUri(), JsonNode.class, createParamsMap(method, p));
        if(!node.has(method.dataNodeName())){
            throw new ApiException("Invalid JSON response: missing field \"" + method.dataNodeName() + "\"");
        }
        JsonNode data = node.get(method.dataNodeName());
        try{
            return objectMapper.readValue(data, type);
        }catch (IOException e){
            throw new UncategorizedApiException("Error deserializing data from Vimeo: " + e.getMessage(), e);
        }
    }
    
    private MultiValueMap<String, Object> createParamsMap(VimeoMethod method, MultiValueMap<String, Object> p){
        MultiValueMap params = new LinkedMultiValueMap(p);
        params.add("method", method.name());
        params.add("format", "json");
        return params;
    }

    protected void doMethod(VimeoMethod method, MultiValueMap<String, Object> p){
        restTemplate.getForObject(getUri(), JsonNode.class, createParamsMap(method, p));
    }

    protected String doAction(VimeoMethod method, MultiValueMap<String, Object> p){
        JsonNode node = restTemplate.getForObject(getUri(), JsonNode.class, createParamsMap(method, p));
        JsonNode arrayOfObject = node.get(method.dataNodeName());
        return arrayOfObject.get(0).get("id").getTextValue();
    }

    private <T> List<T> deserializeDataList(JsonNode jsonNode, final Class<T> elementType) {
        if(jsonNode.size() == 1) {
            jsonNode = jsonNode.get(jsonNode.getFieldNames().next());
        }
        try {
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
            return (List<T>) objectMapper.readValue(jsonNode, listType);
        } catch (IOException e) {
            throw new UncategorizedApiException("Error deserializing data from Vimeo: " + e.getMessage(), e);
        }
    }
    
    protected class ParamsBuilder{
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>(10);

        public void addIfNotNull(String name, Object value){
            if(name == null){
                throw  new IllegalArgumentException();
            }
            if(value != null){
                doAdd(name, value);
            }
        }
        
        public void add(String name, Object value){
            if(value == null || name == null){
                throw new IllegalArgumentException();
            }
            doAdd(name, value);
        }

        public MultiValueMap<String, Object> build(){
            return new LinkedMultiValueMap<String, Object>(params);
        }
        
        private void doAdd(String name, Object value){
            if(value instanceof Collection){
                Collection values = (Collection)value;
                value = StringUtils.collectionToCommaDelimitedString(values);
            }
            params.add(name, value);
        }
    }
}
