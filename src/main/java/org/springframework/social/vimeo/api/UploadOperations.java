package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 8:02 AM
 */
public interface UploadOperations {

    /**
     * Get the space and number of HD uploads left for a user.
     * Numbers are provided in bytes. It's a good idea to check this method
     * before you upload a video to let the user know if their video will
     * be converted to HD. hd_quota will have a value of 0 if the user reached
     * the max number of uploads, 1 otherwise. Resets is the number of the day
     * of the week, starting with Sunday.
     */
    Quota quota();

    /**
     * Generate a new upload ticket for a new video or to replace an existing
     * video. This ticket is good for one upload by one user.
     * Once you have the endpoint and the ticket id, you can upload videos to
     * Vimeo. For more on the format of this transfer check out the Upload API
     * Documentation.
     */
    Ticket ticket(UploadMethod uploadMethod, String videoId);

    /**
     * Check to make sure an upload ticket is still valid
     */
    boolean checkTicket(String ticketId);

    /**
     * Complete the upload process.
     */
    String complete(String ticketId, String filenameWithExtension);

    /**
     * Complete the upload process.
     * If you uploaded only one chunk, you may skip passing a manifest, but if
     * you uploaded multiple files, you must POST a manifest to this method. You
     * can use either an XML or JSON formatted manifest. The manifest should not
     * be included in the signature.
     */
    String confirm(String ticketId, String filenameWithExtension, String jsonManifest, String xmlManifest);

    /**
     * Verify that the chunks were uploaded properly.
     */
    List<Chunk> verifyChunks(String ticketId);

    /**
     * @param videoMime
     * @param videoId
     * @return
     */
    StreamingUploader upload(String videoMime, String videoId);

}
