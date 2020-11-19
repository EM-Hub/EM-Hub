package com.spring.biz.vo;

import org.apache.ibatis.annotations.Case;

public class LecTimeVO {
	  // 강의코드 
    private String lecTtCode;

    // 강의요일 
    private int lecWeek;
    private String lecWeekday;

    // 강의교시 
    private int ttSeq;

    // PK용 
    private int lecTimeNum;
    
    private String facCode;
    

	public String getLecWeekday() {
		return lecWeekday;
	}

	public void setLecWeekday(String lecWeekday) {
		this.lecWeekday = lecWeekday;
	}

	public String getFacCode() {
		return facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	public String getLecTtCode() {
		return lecTtCode;
	}

	public void setLecTtCode(String lecTtCode) {
		this.lecTtCode = lecTtCode;
	}

	public int getLecWeek() {
		return lecWeek;
	}

	public void setLecWeek(int lecWeek) {
		this.lecWeek = lecWeek;
	}

	public int getTtSeq() {
		return ttSeq;
	}

	public void setTtSeq(int ttSeq) {
		this.ttSeq = ttSeq;
	}

	public int getLecTimeNum() {
		return lecTimeNum;
	}

	public void setLecTimeNum(int lecTimeNum) {
		this.lecTimeNum = lecTimeNum;
	}

	@Override
	public String toString() {
		return "LecTimeVO [lecTtCode=" + lecTtCode + ", lecWeek=" + lecWeek + ", lecWeekday=" + lecWeekday + ", ttSeq="
				+ ttSeq + ", lecTimeNum=" + lecTimeNum + ", facCode=" + facCode + "]";
	}



	
    
}
