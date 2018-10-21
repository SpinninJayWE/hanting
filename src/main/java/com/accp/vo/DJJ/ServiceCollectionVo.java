package com.accp.vo.DJJ;

import java.util.Date;

public class ServiceCollectionVo {
	    private Integer sercolleid;
	    private Integer userid;
	    private String servicetitle;
	    private Integer serviceid;
	    private Date collectionTime;
	    private Integer creditscore;
	    private String serviceCoverImg;
	    private Integer servicePrice;
	    private String stName;
	    private Float totalPrice;
	    
	    
		public Float getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(Float totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Integer getSercolleid() {
			return sercolleid;
		}
		public void setSercolleid(Integer sercolleid) {
			this.sercolleid = sercolleid;
		}
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
		public Integer getServiceid() {
			return serviceid;
		}
		public void setServiceid(Integer serviceid) {
			this.serviceid = serviceid;
		}
		public Date getCollectionTime() {
			return collectionTime;
		}
		public void setCollectionTime(Date collectionTime) {
			this.collectionTime = collectionTime;
		}
		public Integer getCreditscore() {
			return creditscore;
		}
		public void setCreditscore(Integer creditscore) {
			this.creditscore = creditscore;
		}
		public String getServiceCoverImg() {
			return serviceCoverImg;
		}
		public void setServiceCoverImg(String serviceCoverImg) {
			this.serviceCoverImg = serviceCoverImg;
		}
		public Integer getServicePrice() {
			return servicePrice;
		}
		public void setServicePrice(Integer servicePrice) {
			this.servicePrice = servicePrice;
		}
		public String getStName() {
			return stName;
		}
		public void setStName(String stName) {
			this.stName = stName;
		}
		public String getServicetitle() {
			return servicetitle;
		}
		public void setServicetitle(String servicetitle) {
			this.servicetitle = servicetitle;
		}
}
