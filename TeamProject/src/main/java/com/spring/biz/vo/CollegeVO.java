package com.spring.biz.vo;

public class CollegeVO {
	private int collegeNum;
	private String collegeName;
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
	@Override
	public String toString() {
		return "CollegeVO [collegeNum=" + collegeNum + ", collegeName=" + collegeName + "]";
	}
	
	
}
