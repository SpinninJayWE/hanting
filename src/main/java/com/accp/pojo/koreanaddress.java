package com.accp.pojo;

public class koreanaddress {
    private Integer kadsid;

    private String kadsname;

    private Integer pid;

    private Byte level;

    public Integer getKadsid() {
        return kadsid;
    }

    public void setKadsid(Integer kadsid) {
        this.kadsid = kadsid;
    }

    public String getKadsname() {
        return kadsname;
    }

    public void setKadsname(String kadsname) {
        this.kadsname = kadsname == null ? null : kadsname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }
}