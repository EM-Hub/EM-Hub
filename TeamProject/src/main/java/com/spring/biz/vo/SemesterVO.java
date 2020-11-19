package com.spring.biz.vo;

public class SemesterVO {
private int semCode;
private int year;
private int term;
private String startDate;
private String endDate;
public int getSemCode() {
	return semCode;
}
public void setSemCode(int semCode) {
	this.semCode = semCode;
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
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return "SemesterVO [semCode=" + semCode + ", year=" + year + ", term=" + term + ", startDate=" + startDate
			+ ", endDate=" + endDate + "]";
}


	
}
