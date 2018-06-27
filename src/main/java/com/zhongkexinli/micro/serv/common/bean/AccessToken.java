package com.zhongkexinli.micro.serv.common.bean;

import java.util.Date;

public class AccessToken {
	private String accessToken;
	private Long expiresIn;
	private Date startDate;
	private Date endDate;
	
	public AccessToken(){
		this.startDate=new Date();
		this.endDate=new Date();
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn*1000;
		endDate.setTime(endDate.getTime()+this.expiresIn);
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
