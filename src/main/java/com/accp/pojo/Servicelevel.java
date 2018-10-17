package com.accp.pojo;

public class Servicelevel {
    private Integer serlevelid;

    private String serlevelname;

    private Integer stid;

    private Integer transactionvalue;

    public Integer getSerlevelid() {
        return serlevelid;
    }

    public void setSerlevelid(Integer serlevelid) {
        this.serlevelid = serlevelid;
    }

    public String getSerlevelname() {
        return serlevelname;
    }

    public void setSerlevelname(String serlevelname) {
        this.serlevelname = serlevelname == null ? null : serlevelname.trim();
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getTransactionvalue() {
        return transactionvalue;
    }

    public void setTransactionvalue(Integer transactionvalue) {
        this.transactionvalue = transactionvalue;
    }
}