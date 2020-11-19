package com.spring.biz.vo;

public class MenuVO{
	// 메인메뉴번호 
    private int mainNum;
    // 이름 
    private String mainName;
    
    private String memGrade;
    
    private String menuUrl;
    
    
    
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public int getMainNum() {
		return mainNum;
	}
	public String getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}
	public void setMainNum(int mainNum) {
		this.mainNum = mainNum;
	}
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	@Override
	public String toString() {
		return "MenuVO [mainNum=" + mainNum + ", mainName=" + mainName + "]";
	}
    
    
}
