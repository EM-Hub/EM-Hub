package com.spring.biz.vo;

import java.util.Date;

public class MemberVO {
	// 회원 정보 
    // 회원아이디 
	    private int memId;

	    // 회원비밀번호 
	    private String memPassword;

	    // 회원성별 
	    private String memGender;

	    // 회원이메일 
	    private String memEmail;

	    // 회원주소 
	    private String memAddr;

	    // 회원등급 
	    private String memGrade;
	    
	    //우편번호
	    private String memZipCode;
	    
	    //전화번호
	    private String memTel;
	    
	    //휴대폰번호
	    private String memPhone;
	    
	    //회원사진
	    private String memPhoto;
	    
	    //회원 생년월일
	    private String memBirthday;
	    
	    private String memName;
	    
	    

		public int getMemId() {
			return memId;
		}

		public void setMemId(int memId) {
			this.memId = memId;
		}

		public String getMemPassword() {
			return memPassword;
		}

		public void setMemPassword(String memPassword) {
			this.memPassword = memPassword;
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

		public String getMemZipCode() {
			return memZipCode;
		}

		public void setMemZipCode(String memZipCode) {
			this.memZipCode = memZipCode;
		}

		public String getMemTel() {
			return memTel;
		}

		public void setMemTel(String memTel) {
			this.memTel = memTel;
		}

		public String getMemPhone() {
			return memPhone;
		}

		public void setMemPhone(String memPhone) {
			this.memPhone = memPhone;
		}

		public String getMemPhoto() {
			return memPhoto;
		}

		public void setMemPhoto(String memPhoto) {
			this.memPhoto = memPhoto;
		}

		public String getMemBirthday() {
			return memBirthday;
		}

		public void setMemBirthday(String memBirthday) {
			this.memBirthday = memBirthday;
		}

		@Override
		public String toString() {
			return "MemberVO [memId=" + memId + ", memPassword=" + memPassword + ", memGender=" + memGender
					+ ", memEmail=" + memEmail + ", memAddr=" + memAddr + ", memGrade=" + memGrade + ", memZipCode="
					+ memZipCode + ", memTel=" + memTel + ", memPhone=" + memPhone + ", memPhoto=" + memPhoto
					+ ", memBirthday=" + memBirthday + "]";
		}

		public String getMemName() {
			return memName;
		}

		public void setMemName(String memName) {
			this.memName = memName;
		}

}
