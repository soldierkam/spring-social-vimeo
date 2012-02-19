package org.springframework.social.vimeo.api.model;

import java.util.List;

/**
 * User: soldier
 * Date: 19.02.12
 * Time: 01:14
 */
public class Presets extends Paging {
    private List<Preset> presets;

    protected Presets(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Preset> presets) {
        super(onThisPage, page, perPage, total);
        this.presets = presets;
    }

    public List<Preset> getPresets() {
        return presets;
    }
}
