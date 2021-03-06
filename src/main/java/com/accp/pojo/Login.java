package com.accp.pojo;

import java.util.List;

public class Login {
    private Integer loginid;

    private Integer userid;

    private String opentid;

    private Integer logintype;

    private String useremail;

    private String userpwd;
    
    private User user;
    
    

  

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpentid() {
        return opentid;
    }

    public void setOpentid(String opentid) {
        this.opentid = opentid == null ? null : opentid.trim();
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }
}