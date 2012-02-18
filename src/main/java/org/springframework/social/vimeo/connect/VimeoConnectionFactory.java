package org.springframework.social.vimeo.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.vimeo.api.Vimeo;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:41
 */
public class VimeoConnectionFactory extends OAuth1ConnectionFactory<Vimeo> {

    public VimeoConnectionFactory(String consumerKey, String consumerSecret) {
        super("vimeo", new VimeoServiceProvider(consumerKey, consumerSecret), new VimeoAdapter());
    }
}
