package org.springframework.social.vimeo.api.impl;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 3:26 PM
 */
class VimeoMethodImpl implements VimeoMethod {

    private final String name;
    private final String data;

    public VimeoMethodImpl(String name, String root) {
        this.name = name;
        this.data = root;
    }

    public VimeoMethodImpl(String name) {
        this.name = name;
        this.data = null;
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
