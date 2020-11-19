package com.spring.biz.vo;

public class DepVO {
	private int depNo;
	private String depName;
	private int collegeNum;
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
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
	@Override
	public String toString() {
		return "DepVO [depNo=" + depNo + ", depName=" + depName + ", collegeNum=" + collegeNum + "]";
	}
	
	
}
