package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/10/12
 * Time: 8:02 AM
 */
public class Quota {

    private String id;
    private Boolean plus;
    private UploadSpace uploadSpace;
    private Boolean hdQuota;
    private Boolean sdQuota;

    public Quota(String id, Boolean plus, UploadSpace uploadSpace, Boolean hdQuota, Boolean sdQuota) {
        this.id = id;
        this.plus = plus;
        this.uploadSpace = uploadSpace;
        this.hdQuota = hdQuota;
        this.sdQuota = sdQuota;
    }

    public String getId() {
        return id;
    }

    public Boolean getPlus() {
        return plus;
    }

    public UploadSpace getUploadSpace() {
        return uploadSpace;
    }

    public Boolean getHdQuota() {
        return hdQuota;
    }

    public Boolean getSdQuota() {
        return sdQuota;
    }
}
