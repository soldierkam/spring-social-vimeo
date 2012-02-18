package org.springframework.social.vimeo.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.vimeo.api.Vimeo;
import org.springframework.social.vimeo.api.impl.VimeoTemplate;

/**
 * User: soldier
 * Date: 18.02.12
 * Time: 20:42
 */
public class VimeoServiceProvider extends AbstractOAuth1ServiceProvider<Vimeo> {
    public VimeoServiceProvider(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret, new VimeoOAuthTemplate(consumerKey, consumerSecret));
    }

    @Override
    public Vimeo getApi(String accessToken, String secret) {
        return new VimeoTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
    }
}
