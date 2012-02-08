package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:22 PM
 */
public abstract class Paging {

    private Integer onThisPage;
    private Integer page;
    private Integer perPage;
    private Integer total;

    protected Paging(Integer onThisPage, Integer page, Integer perPage, Integer total) {
        this.onThisPage = onThisPage;
        this.page = page;
        this.perPage = perPage;
        this.total = total;
    }

    public Integer getOnThisPage() {
        return onThisPage;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }
}
