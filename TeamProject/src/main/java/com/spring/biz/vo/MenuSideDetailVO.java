package com.spring.biz.vo;

public class MenuSideDetailVO extends MenuVO{
	 // 숫자 
    private int sideDetailNum;
    // 사이드디테일이름 
    private String sideDetailName;
    // 참조메인번호
    private int mainNum;
    // 참조사이드번호
    private int sideNum;
    //이동경로
    private String menuUrl;
    
    
    private String mainName;
    private String sideName;
    
    
    
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	public String getSideName() {
		return sideName;
	}
	public void setSideName(String sideName) {
		this.sideName = sideName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public int getSideDetailNum() {
		return sideDetailNum;
	}
	public void setSideDetailNum(int sideDetailNum) {
		this.sideDetailNum = sideDetailNum;
	}
	public String getSideDetailName() {
		return sideDetailName;
	}
	public void setSideDetailName(String sideDetailName) {
		this.sideDetailName = sideDetailName;
	}
	public int getMainNum() {
		return mainNum;
	}
	public void setMainNum(int mainNum) {
		this.mainNum = mainNum;
	}
	public int getSideNum() {
		return sideNum;
	}
	public void setSideNum(int sideNum) {
		this.sideNum = sideNum;
	}
	@Override
	public String toString() {
		return "MenuSideDetailVO [sideDetailNum=" + sideDetailNum + ", sideDetailName=" + sideDetailName + ", mainNum="
				+ mainNum + ", sideNum=" + sideNum + ", menuUrl=" + menuUrl + ", mainName=" + mainName + ", sideName="
				+ sideName + "]";
	}
	
}
