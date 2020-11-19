package com.spring.biz.vo;

public class ExpelVO {
	private int expelNum;
	private int stuNum;
	private String expelDate;
	private String expelReason;
	private String userEmail;
	public int getExpelNum() {
		return expelNum;
	}
	public void setExpelNum(int expelNum) {
		this.expelNum = expelNum;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getExpelDate() {
		return expelDate;
	}
	public void setExpelDate(String expelDate) {
		this.expelDate = expelDate;
	}
	public String getExpelReason() {
		return expelReason;
	}
	public void setExpelReason(String expelReason) {
		this.expelReason = expelReason;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "ExpelVO [expelNum=" + expelNum + ", stuNum=" + stuNum + ", expelDate=" + expelDate + ", expelReason="
				+ expelReason + ", userEmail=" + userEmail + "]";
	}
	
	
	
	

}
