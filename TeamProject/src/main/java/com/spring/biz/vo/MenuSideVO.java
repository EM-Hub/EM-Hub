package com.spring.biz.vo;

public class MenuSideVO extends MenuVO{
	 // 사이드메뉴번호 
    private int sideNum;

    // 이름 
    private String sideName;

    // 참조메인메뉴 
    private int mainNum;

    private String menuUrl;
    
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getSideNum() {
		return sideNum;
	}

	public void setSideNum(int sideNum) {
		this.sideNum = sideNum;
	}

	public String getSideName() {
		return sideName;
	}

	public void setSideName(String sideName) {
		this.sideName = sideName;
	}

	public int getMainNum() {
		return mainNum;
	}

	public void setMainNum(int mainNum) {
		this.mainNum = mainNum;
	}

	@Override
	public String toString() {
		return "MenuSideVO [sideNum=" + sideNum + ", sideName=" + sideName + ", mainNum=" + mainNum + "]";
	}
    
    
	
}
