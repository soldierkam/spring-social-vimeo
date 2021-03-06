package org.springframework.social.vimeo.api.impl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.social.vimeo.api.StreamingUploader;
import org.springframework.social.vimeo.api.UploadOperations;
import org.springframework.social.vimeo.api.model.Chunk;
import org.springframework.social.vimeo.api.model.Quota;
import org.springframework.social.vimeo.api.model.Ticket;
import org.springframework.social.vimeo.api.model.UploadMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 8:20 AM
 */
class UploadTemplate extends AbstractVimeoTemplate implements UploadOperations {

    private final static VimeoMethod QUOTA = new VimeoMethodImpl("vimeo.videos.upload.getQuota", "");
    private final static VimeoMethod TICKET = new VimeoMethodImpl("vimeo.videos.upload.getTicket", "ticket");
    private final static VimeoMethod VALID = new VimeoMethodImpl("vimeo.videos.upload.checkTicket", "");
    private final static VimeoMethod COMPLETE = new VimeoMethodImpl("vimeo.videos.upload.complete", "ticket");
    private final static VimeoMethod CONFIRM = new VimeoMethodImpl("vimeo.videos.upload.confirm", "");

    public UploadTemplate(RestTemplate restTemplate, ObjectMapper mapper, Permission permission) {
        super(restTemplate, mapper, permission);
    }

    @Override
    public Quota quota() {
        return getObject(QUOTA, null, Quota.class);
    }

    @Override
    public Ticket ticket(UploadMethod uploadMethod, String videoId) {
        ParamsBuilder params = new ParamsBuilder();
        params.addIfNotNull("upload_method", uploadMethod == null ? null : uploadMethod.name().toLowerCase());
        params.addIfNotNull("video_id", videoId);
        return getObject(TICKET, params.build(), Ticket.class);
    }

    @Override
    public StreamingUploader upload(String videoMime, String videoId) {
        Quota userQuota = this.quota();
        Ticket uploadTicket = this.ticket(UploadMethod.STREAMING, videoId);
        return new StreamingUploaderImpl(this, restTemplate, userQuota, uploadTicket, videoMime);
    }

    @Override
    public boolean checkTicket(String ticketId) {
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.add("ticket_id", ticketId);
        JsonNode node = getObject(VALID, paramsBuilder.build(), JsonNode.class);
        return "1".equals(node.get("valid"));
    }

    @Override
    public String complete(String ticketId, String filenameWithExtension) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("ticket_id", ticketId);
        params.addIfNotNull("filename", filenameWithExtension);
        JsonNode node = getObject(COMPLETE, params.build(), JsonNode.class);
        return node.get("video_id").getTextValue();
    }

    @Override
    public String confirm(String ticketId, String filenameWithExtension, String jsonManifest, String xmlManifest) {
        ParamsBuilder params = new ParamsBuilder();
        params.add("ticket_id", ticketId);
        params.addIfNotNull("filename", filenameWithExtension);
        params.addIfNotNull("json_manifest", jsonManifest);
        params.addIfNotNull("xml_manifest", xmlManifest);
        JsonNode node = getObject(CONFIRM, params.build(), JsonNode.class);
        return node.get("video_id").getTextValue();
    }

    @Override
    public String verifyManifest(String ticketId, String jsonManifest, String xmlManifest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Chunk> verifyChunks(String ticketId) {
        throw new UnsupportedOperationException();
    }
}

