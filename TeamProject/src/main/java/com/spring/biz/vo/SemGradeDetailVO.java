package com.spring.biz.vo;

public class SemGradeDetailVO {
	private int stuNum;
	private String lecTtCode;
	private String lectrueName;
	private String profName;
	private int lecCredit;
	private String gradeAbc;
	private double gradeScore;
	private int semCode;
	
	
	
	public String getLecTtCode() {
		return lecTtCode;
	}
	public void setLecTtCode(String lecTtCode) {
		this.lecTtCode = lecTtCode;
	}
	public int getSemCode() {
		return semCode;
	}
	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getLectrueName() {
		return lectrueName;
	}
	public void setLectrueName(String lectrueName) {
		this.lectrueName = lectrueName;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public int getLecCredit() {
		return lecCredit;
	}
	public void setLecCredit(int lecCredit) {
		this.lecCredit = lecCredit;
	}
	public String getGradeAbc() {
		return gradeAbc;
	}
	public void setGradeAbc(String gradeAbc) {
		this.gradeAbc = gradeAbc;
	}
	public double getGradeScore() {
		return gradeScore;
	}
	public void setGradeScore(double gradeScore) {
		this.gradeScore = gradeScore;
	}
	@Override
	public String toString() {
		return "semGradeDetailVO [stuNum=" + stuNum + ", lecTtCode=" + lecTtCode + ", lectrueName=" + lectrueName
				+ ", profName=" + profName + ", lecCredit=" + lecCredit + ", gradeAbc=" + gradeAbc + ", gradeScore="
				+ gradeScore + "]";
	}
	
	

}
