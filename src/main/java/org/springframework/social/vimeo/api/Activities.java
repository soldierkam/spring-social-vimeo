package org.springframework.social.vimeo.api;

import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:18 PM
 */
public class Activities extends Paging {

    private List<Activity> activities;

    public Activities(Integer onThisPage, Integer page, Integer perPage, Integer total, List<Activity> activities) {
        super(onThisPage, page, perPage, total);
        this.activities = activities;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
