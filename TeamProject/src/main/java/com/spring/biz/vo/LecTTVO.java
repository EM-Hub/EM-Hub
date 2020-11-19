package com.spring.biz.vo;

import java.util.List;

public class LecTTVO {
	private String lecTtCode;
	private String lecCode;

	private String facCode;
	private int stuMaxNum;
	private int stuAppNum;
	private int semCode;
	private List<LecTimeVO> lecTimeList;
	
	
	public String getLecTtCode() {
		return lecTtCode;
	}
	public void setLecTtCode(String lecTtCode) {
		this.lecTtCode = lecTtCode;
	}
	public String getLecCode() {
		return lecCode;
	}
	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
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
	public int getStuAppNum() {
		return stuAppNum;
	}
	public void setStuAppNum(int stuAppNum) {
		this.stuAppNum = stuAppNum;
	}
	public int getSemCode() {
		return semCode;
	}
	public void setSemCode(int semCode) {
		this.semCode = semCode;
	}
	@Override
	public String toString() {
		return "LecTTVO [lecTtCode=" + lecTtCode + ", lecCode=" + lecCode + ", facCode=" + facCode + ", stuMaxNum="
				+ stuMaxNum + ", stuAppNum=" + stuAppNum + ", semCode=" + semCode + "]";
	}
	public List<LecTimeVO> getLecTimeList() {
		return lecTimeList;
	}
	public void setLecTimeList(List<LecTimeVO> lecTimeList) {
		this.lecTimeList = lecTimeList;
	}
	
	
	

	
}
