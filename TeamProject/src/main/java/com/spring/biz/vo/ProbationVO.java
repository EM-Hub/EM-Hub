package com.spring.biz.vo;

public class ProbationVO {
	private int probNum;
	private int stuNum;
	private String probDate;
	private int semCode;
	private String probReason;
	private String userEmail;
	
	
	
	
	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public int getProbNum() {
		return probNum;
	}



	public void setProbNum(int probNum) {
		this.probNum = probNum;
	}



	public int getStuNum() {
		return stuNum;
	}



	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}



	public String getProbDate() {
		return probDate;
	}



	public void setProbDate(String probDate) {
		this.probDate = probDate;
	}



	public int getSemCode() {
		return semCode;
	}



	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}



	public String getProbReason() {
		return probReason;
	}



	public void setProbReason(String probReason) {
		this.probReason = probReason;
	}



	@Override
	public String toString() {
		return "ProbationVO [probNum=" + probNum + ", stuNum=" + stuNum + ", probDate=" + probDate + ", semCode="
				+ semCode + ", probReason=" + probReason + "]";
	}
	
	

}
