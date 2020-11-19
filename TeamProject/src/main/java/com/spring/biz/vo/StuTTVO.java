package com.spring.biz.vo;

import java.util.List;

public class StuTTVO {
    // PK용 
    private int stuTtCode;
    // 학생번호 
    private int stuNum;
    // 강의코드 
    private String lecTtCode;
    // 시간
    private List<LecTimeVO> lecTimeList;
    //과
    private String depName;
    //대학
    private String collegeName;
    //강의명 
    private String lectureName;
    //학점 
    private int lecCredit;
    //권장학년 
    private int recYear;
    //교수
    private String profName;
    //학기
    private int semCode;
	public int getStuTtCode() {
		return stuTtCode;
	}
	public void setStuTtCode(int stuTtCode) {
		this.stuTtCode = stuTtCode;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getLecTtCode() {
		return lecTtCode;
	}
	public void setLecTtCode(String lecTtCode) {
		this.lecTtCode = lecTtCode;
	}
	public List<LecTimeVO> getLecTimeList() {
		return lecTimeList;
	}
	public void setLecTimeList(List<LecTimeVO> lecTimeList) {
		this.lecTimeList = lecTimeList;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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
	public int getRecYear() {
		return recYear;
	}
	public void setRecYear(int recYear) {
		this.recYear = recYear;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public int getSemCode() {
		return semCode;
	}
	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	@Override
	public String toString() {
		return "StuTTVO [stuTtCode=" + stuTtCode + ", stuNum=" + stuNum + ", lecTtCode=" + lecTtCode + ", lecTimeList="
				+ lecTimeList + ", depName=" + depName + ", collegeName=" + collegeName + ", lectureName=" + lectureName
				+ ", lecCredit=" + lecCredit + ", recYear=" + recYear + ", profName=" + profName + ", semCode="
				+ semCode + "]";
	}
	
	
	
	
}	
