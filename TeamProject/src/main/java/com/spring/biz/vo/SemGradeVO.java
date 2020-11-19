package com.spring.biz.vo;

public class SemGradeVO {
	private int semCode;
	private float semAvgGrade;
	private int semTotalCredit;
	private int acqiredCredit;
	
	
	
	public int getAcqiredCredit() {
		return acqiredCredit;
	}


	public void setAcqiredCredit(int acqiredCredit) {
		this.acqiredCredit = acqiredCredit;
	}


	public int getSemCode() {
		return semCode;
	}
	

	public float getSemAvgGrade() {
		return semAvgGrade;
	}


	public void setSemAvgGrade(float semAvgGrade) {
		this.semAvgGrade = semAvgGrade;
	}


	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	public int getSemTotalCredit() {
		return semTotalCredit;
	}
	public void setSemTotalCredit(int semTotalCredit) {
		this.semTotalCredit = semTotalCredit;
	}
	@Override
	public String toString() {
		return "SemGrade [semCode=" + semCode + ", semAvgGrade=" + semAvgGrade + ", semTotalCredit=" + semTotalCredit
				+ ", getSemCode()=" + getSemCode() + ", getSemAvgGrade()=" + getSemAvgGrade() + ", getSemTotalCredit()="
				+ getSemTotalCredit() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
