package com.spring.biz.vo;

public class StudentVO {
	//학생 정보
	private int stuNum;
	private int depNo;
	private String depName;
	private int depNo2;
	private int statusNum;
	private String memStatus;
	private int stuYear;
	private String stuName;
	private int collegeNum;
	private String collegeName;
	
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public int getDepNo2() {
		return depNo2;
	}
	public void setDepNo2(int depNo2) {
		this.depNo2 = depNo2;
	}
	public int getStatusNum() {
		return statusNum;
	}
	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}
	public int getStuYear() {
		return stuYear;
	}
	public void setStuYear(int stuYear) {
		this.stuYear = stuYear;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public int getCollegeNum() {
		return collegeNum;
	}
	public void setCollegeNum(int collegeNum) {
		this.collegeNum = collegeNum;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}
	@Override
	public String toString() {
		return "StudentVO [stuNum=" + stuNum + ", depNo=" + depNo + ", depName=" + depName + ", depNo2=" + depNo2
				+ ", statusNum=" + statusNum + ", memStatus=" + memStatus + ", stuYear=" + stuYear + ", stuName="
				+ stuName + ", collegeNum=" + collegeNum + ", collegeName=" + collegeName + "]";
	}
	

}
