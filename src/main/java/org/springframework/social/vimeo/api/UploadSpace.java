package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 9:00 AM
 */
public class UploadSpace {
    private Long free;
    private Long max;
    private Long resets;
    private Long used;

    public Long getFree() {
        return free;
    }

    public Long getMax() {
        return max;
    }

    public Long getResets() {
        return resets;
    }

    public Long getUsed() {
        return used;
    }

    public UploadSpace(Long free, Long max, Long resets, Long used) {

        this.free = free;
        this.max = max;
        this.resets = resets;
        this.used = used;
    }
}
