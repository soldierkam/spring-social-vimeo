package org.springframework.social.vimeo.api.impl;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 6:05 PM
 */
public class Collection {
    private Integer onThisPage;
    private Integer pageNumber;
    private Integer perPage;
    private Integer total;

    public Collection(Integer onThisPage, Integer pageNumber, Integer perPage, Integer total) {
        this.onThisPage = onThisPage;
        this.pageNumber = pageNumber;
        this.perPage = perPage;
        this.total = total;
    }

    public Integer getOnThisPage() {
        return onThisPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }
}
