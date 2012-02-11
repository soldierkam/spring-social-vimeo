package org.springframework.social.vimeo.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.social.vimeo.api.Quota;
import org.springframework.social.vimeo.api.StreamingUploader;
import org.springframework.social.vimeo.api.Ticket;
import org.springframework.social.vimeo.api.UploadOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 10:20 AM
 */
public class StreamingUploaderImpl implements StreamingUploader {

    private final Quota quota;
    private final Ticket ticket;
    private final String mime;
    private final RestTemplate restTemplate;
    private final UploadOperations uploadOperations;
    private Long available;
    private final Object monitor = new Object();
    private final static Pattern RANGE_HEADER = Pattern.compile("bytes=(\\d+)-(\\d+)");

    protected StreamingUploaderImpl(UploadOperations operations, RestTemplate restTemplate, Quota quota, Ticket ticket, String mime) {
        this.uploadOperations = operations;
        this.quota = quota;
        this.ticket = ticket;
        this.mime = mime;
        this.restTemplate = restTemplate;
        available = ticket.getMaxFileSize();
    }

    @Override
    public void send(File file) throws IOException {
        short uploadCount = 0;
        final short maxUploadCount = 3;
        long fileSizeOnServer = 0;
        do {
            uploadCount++;
            doUpload(new FileInputStream(file), file.length(), fileSizeOnServer);
            fileSizeOnServer = verifiedSize(file.length());
        } while (uploadCount <= maxUploadCount && fileSizeOnServer != file.length());
        uploadOperations.complete(ticket.getId(), file.getName());
    }

    private void doUpload(InputStream stream, long size, long offset) throws IOException {
        synchronized (monitor) {
            if (available < size) {
                throw new IOException("file too big");
            }
            available -= size;
        }
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>(5);
        headers.add("Content-Length", Long.valueOf(size).toString());
        headers.add("Content-Type", mime);
        if (offset > 0) {
            stream.skip(offset);
        }
        HttpEntity<InputStream> body = new HttpEntity(stream, headers);
        restTemplate.put(ticket.getEndpoint().toString(), body);
    }

    private long verifiedSize(long size) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>(5);
        headers.add("Content-Length", "0");
        headers.add("Content-Range", "bytes */*");
        HttpEntity<InputStream> body = new HttpEntity("", headers);
        HttpEntity<?> response = restTemplate.exchange(ticket.getEndpoint().toString(), HttpMethod.PUT, body, null);
        Range range = fetchRange(response);
        if (range.from != 0) {
            throw new RuntimeException();
        }
        return range.to;
    }

    private Range fetchRange(HttpEntity response) {
        String rangeHeader = response.getHeaders().getFirst("Range");
        Matcher rangeMatcher = RANGE_HEADER.matcher(rangeHeader);
        if (!rangeMatcher.matches()) {
            throw new RuntimeException("range header: " + rangeHeader);
        }
        final Long from = Long.valueOf(rangeMatcher.group(1));
        final Long to = Long.valueOf(rangeMatcher.group(2));
        return new Range(from, to);
    }

    private static class Range {
        long from;
        long to;

        private Range(long from, long to) {
            this.from = from;
            this.to = to;
        }
    }
}
