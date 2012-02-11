package org.springframework.social.vimeo.api;

import java.io.File;
import java.io.IOException;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 10:01 AM
 */
public interface StreamingUploader {

    void send(File file) throws IOException;
}
