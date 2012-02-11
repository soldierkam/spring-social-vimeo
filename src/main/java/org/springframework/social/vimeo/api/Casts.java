package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 11.02.12
 * Time: 23:34
 */
public class Casts extends Paging {

    private List<Cast> casts;

    public Casts(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Cast> casts) {
        super(onThisPage, page, perPage, total);
        this.casts = casts;
    }

    public List<Cast> getCasts() {
        return casts;
    }
}
