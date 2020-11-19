package com.spring.biz.vo;

public class CalendarVO {

	private String calTitle;
	private String calColor;
	private String calStartDate;
	private String calEndDate;
	private int calId;
	
	public String getCalTitle() {
		return calTitle;
	}
	public void setCalTitle(String calTitle) {
		this.calTitle = calTitle;
	}
	public String getCalColor() {
		return calColor;
	}
	public void setCalColor(String calColor) {
		this.calColor = calColor;
	}
	public String getCalStartDate() {
		return calStartDate;
	}
	public void setCalStartDate(String calStartDate) {
		this.calStartDate = calStartDate;
	}
	public String getCalEndDate() {
		return calEndDate;
	}
	public void setCalEndDate(String calEndDate) {
		this.calEndDate = calEndDate;
	}
	public int getCalId() {
		return calId;
	}
	public void setCalId(int calId) {
		this.calId = calId;
	}
	@Override
	public String toString() {
		return "CalendarVO [calTitle=" + calTitle + ", calColor=" + calColor + ", calStartDate=" + calStartDate
				+ ", calEndDate=" + calEndDate + ", calId=" + calId + "]";
	}
	
}
