package com.accp.pojo;

import java.util.Date;

public class Putforward {
    private Integer pfid;

    private Integer userid;

    private String bankname;

    private Date submittime;

    private Float money;

    private Integer auditstatus;

    public Integer getPfid() {
        return pfid;
    }

    public void setPfid(Integer pfid) {
        this.pfid = pfid;
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

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }
}