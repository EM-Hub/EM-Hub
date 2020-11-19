package com.spring.biz.vo;


public class MyGradeVO {

	private int year;
	private int term;
	private String lecCode;
	private String lectureName;
	private int gradeNum;
	private double gradeScore;
	private String gradeAbc;
	private int stuNum;
	private int semCode;
	private int lecCredit;
	
	
	@Override
	public String toString() {
		return "MyGradeVO [year=" + year + ", term=" + term + ", lecCode=" + lecCode + ", lectureName=" + lectureName
				+ ", gradeNum=" + gradeNum + ", gradeScore=" + gradeScore + ", gradeAbc=" + gradeAbc + ", stuNum="
				+ stuNum + ", semCode=" + semCode + ", lecCredit=" + lecCredit + "]";
	}

	public double getGradeScore() {
		return gradeScore;
	}

	public void setGradeScore(double gradeScore) {
		this.gradeScore = gradeScore;
	}

	public int getLecCredit() {
		return lecCredit;
	}

	public void setLecCredit(int lecCredit) {
		this.lecCredit = lecCredit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getLecCode() {
		return lecCode;
	}

	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public int getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getGradeAbc() {
		return gradeAbc;
	}

	public void setGradeAbc(String gradeAbc) {
		this.gradeAbc = gradeAbc;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getSemCode() {
		return semCode;
	}

	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	
}