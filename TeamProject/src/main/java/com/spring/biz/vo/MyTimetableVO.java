package com.spring.biz.vo;

import java.util.List;

public class MyTimetableVO {
	private String stuTtCode;
	private String lecTtCode;
	private String lectureName;
	private int lecCredit;
	private String profName;
	private List<LecTimeVO> lecTimeList;
	private int semCode;
	private int memId;
	
	
	
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public int getSemCode() {
		return semCode;
	}
	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	public String getStuTtCode() {
		return stuTtCode;
	}
	public void setStuTtCode(String stuTtCode) {
		this.stuTtCode = stuTtCode;
	}
	public String getLecTtCode() {
		return lecTtCode;
	}
	public void setLecTtCode(String lecTtCode) {
		this.lecTtCode = lecTtCode;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public int getLecCredit() {
		return lecCredit;
	}
	public void setLecCredit(int lecCredit) {
		this.lecCredit = lecCredit;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public List<LecTimeVO> getLecTimeList() {
		return lecTimeList;
	}
	public void setLecTimeList(List<LecTimeVO> lecTimeList) {
		this.lecTimeList = lecTimeList;
	}
	@Override
	public String toString() {
		return "MyTimetable [stuTtCode=" + stuTtCode + ", lecTtCode=" + lecTtCode + ", lectureName=" + lectureName
				+ ", lecCredit=" + lecCredit + ", profName=" + profName + ", lecTimeList=" + lecTimeList + "]";
	}
	
	

}
