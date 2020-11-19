package com.spring.biz.vo;


public class LectureVO {

	    // 과목번호 
	    private String lecCode;

	    // 소속학과 
	    private int depNo;

	    // 담당교수 
	    private int profNum;

	    // 담당조교 
	    private int asstNum;

	    // 학점 
	    private int lecCredit;

	    // 권장학년 
	    private int recYear;

	    // 강의명 
	    private String lectureName;
	    
	    private int regEmp;

	    // 강의계획서 
	    private String attachment;
	    private String profName;
	    private String depName;
	    private int collegeNum;
	    private String asstName;
	    private String collegeName;
	    
	    //LecTTVO
	    private String lecTtCode;
		private String lecYear;
		private String lecTerm;
		private String lecWeek;
		private int ttSeq;
		private String facCode;
		private int stuMaxNum;
		public String getLecCode() {
			return lecCode;
		}
		public void setLecCode(String lecCode) {
			this.lecCode = lecCode;
		}
		public int getDepNo() {
			return depNo;
		}
		public void setDepNo(int depNo) {
			this.depNo = depNo;
		}
		public int getProfNum() {
			return profNum;
		}
		public void setProfNum(int profNum) {
			this.profNum = profNum;
		}
		public int getAsstNum() {
			return asstNum;
		}
		public void setAsstNum(int asstNum) {
			this.asstNum = asstNum;
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
		public String getLectureName() {
			return lectureName;
		}
		public void setLectureName(String lectureName) {
			this.lectureName = lectureName;
		}
		public String getAttachment() {
			return attachment;
		}
		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}
		public String getProfName() {
			return profName;
		}
		public void setProfName(String profName) {
			this.profName = profName;
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
		public String getLecTtCode() {
			return lecTtCode;
		}
		public void setLecTtCode(String lecTtCode) {
			this.lecTtCode = lecTtCode;
		}
		public String getLecYear() {
			return lecYear;
		}
		public void setLecYear(String lecYear) {
			this.lecYear = lecYear;
		}
		public String getLecTerm() {
			return lecTerm;
		}
		public void setLecTerm(String lecTerm) {
			this.lecTerm = lecTerm;
		}
		public String getLecWeek() {
			return lecWeek;
		}
		public void setLecWeek(String lecWeek) {
			this.lecWeek = lecWeek;
		}
		public int getTtSeq() {
			return ttSeq;
		}
		public void setTtSeq(int ttSeq) {
			this.ttSeq = ttSeq;
		}
		public String getFacCode() {
			return facCode;
		}
		public void setFacCode(String facCode) {
			this.facCode = facCode;
		}
		public int getStuMaxNum() {
			return stuMaxNum;
		}
		public void setStuMaxNum(int stuMaxNum) {
			this.stuMaxNum = stuMaxNum;
		}
		@Override
		public String toString() {
			return "LectureVO [lecCode=" + lecCode + ", depNo=" + depNo + ", profNum=" + profNum + ", asstNum="
					+ asstNum + ", lecCredit=" + lecCredit + ", recYear=" + recYear + ", lectureName=" + lectureName
					+ ", attachment=" + attachment + ", profName=" + profName + ", depName=" + depName + ", collegeNum="
					+ collegeNum + ", lecTtCode=" + lecTtCode + ", lecYear=" + lecYear + ", lecTerm=" + lecTerm
					+ ", lecWeek=" + lecWeek + ", ttSeq=" + ttSeq + ", facCode=" + facCode + ", stuMaxNum=" + stuMaxNum
					+ "]";
		}
		public String getAsstName() {
			return asstName;
		}
		public void setAsstName(String asstName) {
			this.asstName = asstName;
		}
		public String getCollegeName() {
			return collegeName;
		}
		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}
		public int getRegEmp() {
			return regEmp;
		}
		public void setRegEmp(int regEmp) {
			this.regEmp = regEmp;
		}
	    
	
}
