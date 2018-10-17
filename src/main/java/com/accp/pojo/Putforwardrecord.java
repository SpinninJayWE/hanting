package com.accp.pojo;

import java.util.Date;

public class Putforwardrecord {
    private Integer pfrid;

    private Integer userid;

    private String bankname;

    private Date submittime;

    private Date completetime;

    private Float money;

    private String adminopinion;

    public Integer getPfrid() {
        return pfrid;
    }

    public void setPfrid(Integer pfrid) {
        this.pfrid = pfrid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getCompletetime() {
        return completetime;
    }

    public void setCompletetime(Date completetime) {
        this.completetime = completetime;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getAdminopinion() {
        return adminopinion;
    }

    public void setAdminopinion(String adminopinion) {
        this.adminopinion = adminopinion == null ? null : adminopinion.trim();
    }
}