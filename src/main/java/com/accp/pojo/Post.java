package com.accp.pojo;

import java.util.Date;

public class Post {
	private Integer postid;

	private Integer userid;

	private Integer browsenumber;

	private Integer commentnumber;

	private Integer fabulousnumber;

	private Integer collectionnumber;

	private Integer fmid;

	private String title;

	private Date releasetime;

	private Integer operatingstate;

	private Integer recommend;

	private Integer auditstatus;
	private String content;

	private String adminopinion;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getAdminopinion() {
		return adminopinion;
	}

	public void setAdminopinion(String adminopinion) {
		this.adminopinion = adminopinion == null ? null : adminopinion.trim();
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getBrowsenumber() {
		return browsenumber;
	}

	public void setBrowsenumber(Integer browsenumber) {
		this.browsenumber = browsenumber;
	}

	public Integer getCommentnumber() {
		return commentnumber;
	}

	public void setCommentnumber(Integer commentnumber) {
		this.commentnumber = commentnumber;
	}

	public Integer getFabulousnumber() {
		return fabulousnumber;
	}

	public void setFabulousnumber(Integer fabulousnumber) {
		this.fabulousnumber = fabulousnumber;
	}

	public Integer getCollectionnumber() {
		return collectionnumber;
	}

	public void setCollectionnumber(Integer collectionnumber) {
		this.collectionnumber = collectionnumber;
	}

	public Integer getFmid() {
		return fmid;
	}

	public void setFmid(Integer fmid) {
		this.fmid = fmid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Date getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public Integer getOperatingstate() {
		return operatingstate;
	}

	public void setOperatingstate(Integer operatingstate) {
		this.operatingstate = operatingstate;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}
}