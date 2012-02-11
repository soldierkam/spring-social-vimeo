package org.springframework.social.vimeo.api.impl;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: soldier
 * Date: 10.02.12
 * Time: 23:46
 */
public class StreamHttpMessageConverter extends AbstractHttpMessageConverter<InputStream> {

    public StreamHttpMessageConverter() {
        super(MediaType.ALL);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return InputStream.class.isAssignableFrom(clazz);
    }

    @Override
    protected InputStream readInternal(Class<? extends InputStream> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return inputMessage.getBody();
    }

    @Override
    protected void writeInternal(InputStream inputStream, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        IOUtils.copy(inputStream, outputMessage.getBody());
    }
}
