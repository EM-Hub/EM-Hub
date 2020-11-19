package com.spring.biz.vo;

public class EmpInfoVO {
	private int empNo;
	private int memId;
	private String memGender;
	private String memEmail;
	private String memAddr;
	private String memGrade;
	private String memPhone;
	private String memTel;
	private String memZipCode;
	private String memBirthday;
	private String memPhoto;
	private int depNo;
	private String empJob;
	private String empName;
	private int collegeNum;
	private String collegeName;
	private String depName;
	
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemZipCode() {
		return memZipCode;
	}
	public void setMemZipCode(String memZipCode) {
		this.memZipCode = memZipCode;
	}
	public String getMemBirthday() {
		return memBirthday;
	}
	public void setMemBirthday(String memBirthday) {
		this.memBirthday = memBirthday;
	}
	public String getMemPhoto() {
		return memPhoto;
	}
	public void setMemPhoto(String memPhoto) {
		this.memPhoto = memPhoto;
	}
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "EmpInfoVO [empNo=" + empNo + ", memId=" + memId + ", memGender=" + memGender + ", memEmail=" + memEmail
				+ ", memAddr=" + memAddr + ", memGrade=" + memGrade + ", memPhone=" + memPhone + ", memTel=" + memTel
				+ ", memZipCode=" + memZipCode + ", memBirthday=" + memBirthday + ", memPhoto=" + memPhoto + ", depNo="
				+ depNo + ", empJob=" + empJob + ", empName=" + empName + ", collegeNum=" + collegeNum
				+ ", collegeName=" + collegeName + ", depName=" + depName + "]";
	}

}
