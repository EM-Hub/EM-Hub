package com.spring.biz.vo;

import java.util.List;

public class FacUseListVO {
	private int facUseNum;
	private String facCode;
	private String facUseDay;
	private int ttSeq;
	private int memId;
	private String purpose;
	private String userEmail;
	private String facName;
	private String ttStartTime;
	private String ttEndTime;
	private List<String> facCodeList;
	private String fromDate;
	private String toDate;
	private String facUseTime;
	private String cacelReason;
	
	
	
	
	
	
	
	public String getCacelReason() {
		return cacelReason;
	}
	public void setCacelReason(String cacelReason) {
		this.cacelReason = cacelReason;
	}
	public String getFacUseTime() {
		return facUseTime;
	}
	public void setFacUseTime(String facUseTime) {
		this.facUseTime = facUseTime;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public List<String> getFacCodeList() {
		return facCodeList;
	}
	public void setFacCodeList(List<String> facCodeList) {
		this.facCodeList = facCodeList;
	}
	public String getTtStartTime() {
		return ttStartTime;
	}
	public void setTtStartTime(String ttStartTime) {
		this.ttStartTime = ttStartTime;
	}
	public String getTtEndTime() {
		return ttEndTime;
	}
	public void setTtEndTime(String ttEndTime) {
		this.ttEndTime = ttEndTime;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getFacUseNum() {
		return facUseNum;
	}
	public void setFacUseNum(int facUseNum) {
		this.facUseNum = facUseNum;
	}
	public String getFacCode() {
		return facCode;
	}
	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}
	public String getFacUseDay() {
		return facUseDay;
	}
	public void setFacUseDay(String facUseDay) {
		this.facUseDay = facUseDay;
	}
	public int getTtSeq() {
		return ttSeq;
	}
	public void setTtSeq(int ttSeq) {
		this.ttSeq = ttSeq;
	}
	@Override
	public String toString() {
		return "FacUseListVO [facUseNum=" + facUseNum + ", facCode=" + facCode + ", facUseDay=" + facUseDay + ", ttSeq="
				+ ttSeq + "]";
	}
	
	
}   
