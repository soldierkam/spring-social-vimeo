package org.springframework.social.vimeo.api.impl;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 3:24 PM
 */
interface VimeoMethod {

    String name();

    String dataNodeName();

    Class<? extends RuntimeException> getErrorHandler(Integer code);

    boolean hasDataNodeName();
}
