package com.spring.biz.vo;


public class TimetableVO {
	private int ttSeq;
	private String ttStartTime;
	private String ttEndTime;
	private String isReserved;

	
	
	
	public int getTtSeq() {
		return ttSeq;
	}
	public void setTtSeq(int ttSeq) {
		this.ttSeq = ttSeq;
	}
	public String getTtStartTime() {
		return ttStartTime;
	}
	public void setTtStartTime(String ttStartTime) {
		this.ttStartTime = ttStartTime;
	}
	public String getTtEndTime() {
		return ttEndTime;
	}
	public void setTtEndTime(String ttEndTime) {
		this.ttEndTime = ttEndTime;
	}
	public String getIsReserved() {
		return isReserved;
	}
	public void setIsReserved(String isReserved) {
		this.isReserved = isReserved;
	}
	@Override
	public String toString() {
		return "TimetableVO [ttSeq=" + ttSeq + ", ttStartTime=" + ttStartTime + ", ttEndTime=" + ttEndTime
				+ ", isReserved=" + isReserved + "]";
	}
	
	
}
