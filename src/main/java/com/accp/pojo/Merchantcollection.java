package com.accp.pojo;

public class Merchantcollection {
    private Integer collectid;

    private Integer userid;

    private Integer merchantorservicebyid;

    private String merchantorservicebyname;

    private Integer collecttype;

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMerchantorservicebyid() {
        return merchantorservicebyid;
    }

    public void setMerchantorservicebyid(Integer merchantorservicebyid) {
        this.merchantorservicebyid = merchantorservicebyid;
    }

    public String getMerchantorservicebyname() {
        return merchantorservicebyname;
    }

    public void setMerchantorservicebyname(String merchantorservicebyname) {
        this.merchantorservicebyname = merchantorservicebyname == null ? null : merchantorservicebyname.trim();
    }

    public Integer getCollecttype() {
        return collecttype;
    }

    public void setCollecttype(Integer collecttype) {
        this.collecttype = collecttype;
    }
}