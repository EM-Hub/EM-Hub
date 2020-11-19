package com.spring.biz.vo;

public class BoardCategoryListVO {

	private int categoryNum;
	private String categoryName;
	
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "BoardCategoryList [categoryNum=" + categoryNum + ", categoryName=" + categoryName + "]";
	}
}
