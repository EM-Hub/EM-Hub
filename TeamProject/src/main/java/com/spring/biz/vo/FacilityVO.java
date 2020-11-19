package com.spring.biz.vo;

public class FacilityVO {
	private String faCode;
	private String facLoc;
	private String facLocDetail;
	private String facName;
	public String getFaCode() {
		return faCode;
	}
	public void setFaCode(String faCode) {
		this.faCode = faCode;
	}
	public String getFacLoc() {
		return facLoc;
	}
	public void setFacLoc(String facLoc) {
		this.facLoc = facLoc;
	}
	public String getFacLocDetail() {
		return facLocDetail;
	}
	public void setFacLocDetail(String facLocDetail) {
		this.facLocDetail = facLocDetail;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	@Override
	public String toString() {
		return "FacilityVO [faCode=" + faCode + ", facLoc=" + facLoc + ", facLocDetail=" + facLocDetail + ", facName="
				+ facName + "]";
	}
	
}   
