package com.spring.biz.vo;

public class StatusRegVO {
	//신청번호
	private int regNum;
	//기존학적상태
	private int fromStatus;
	//변경학적
	private int toStatus;
	//관리자 승인
	private String isComfirm;
	//신청학생-학번
	private int stuNum;
	//신청학생-이름
	private String stuName;
	//신청일
	private String applicationDate;
	//승인일
	private String approvalDate;
	
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	public int getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(int fromStatus) {
		this.fromStatus = fromStatus;
	}
	public int getToStatus() {
		return toStatus;
	}
	public void setToStatus(int toStatus) {
		this.toStatus = toStatus;
	}
	public String getIsComfirm() {
		return isComfirm;
	}
	public void setIsComfirm(String isComfirm) {
		this.isComfirm = isComfirm;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	
}
