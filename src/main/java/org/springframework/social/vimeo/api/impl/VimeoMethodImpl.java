package org.springframework.social.vimeo.api.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 3:26 PM
 */
class VimeoMethodImpl implements VimeoMethod {

    private final String name;
    private final String data;
    private final Map<Integer, Class<? extends RuntimeException>> handlers = new HashMap<Integer, Class<? extends RuntimeException>>();

    public VimeoMethodImpl(String name, String root) {
        this.name = name;
        this.data = root;
    }

    public VimeoMethodImpl(String name) {
        this.name = name;
        this.data = null;
    }

    public void add(Integer code, Class<? extends RuntimeException> clazz) {
        handlers.put(code, clazz);
    }

    @Override
    public Class<? extends RuntimeException> getErrorHandler(Integer code) {
        return handlers.get(code);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String dataNodeName() {
        if (data == null) {
            throw new IllegalStateException();
        }
        return data;
    }

    @Override
    public boolean hasDataNodeName() {
        return data != null && !data.equals("");
    }
}
