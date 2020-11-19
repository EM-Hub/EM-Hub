package com.spring.biz.vo;

import java.util.Date;

public class RepairRequestVO extends Pagination{
    // 수리등록 번호 
    private Integer requestNum;

    // 글 제목 
    private String requestTitle;

    // 글 내용 
    private String requestContent;
    
    // 글 작성자 
    private String requestName;
    
    // 글 작성일 
    private String requestCreate;
    
    // 글 조회수 
    private int requestReadCnt;
    
    private int rowNum;
    
    private int stuNum;
    private int stuYear;
    private String depName;
    
    
    public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
    public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getStuYear() {
		return stuYear;
	}
	public void setStuYear(int stuYear) {
		this.stuYear = stuYear;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	private String requestStatus;
    
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public Integer getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(Integer requestNum) {
		this.requestNum = requestNum;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRequestCreate() {
		return requestCreate;
	}
	public void setRequestCreate(String requestCreate) {
		this.requestCreate = requestCreate;
	}
	public int getRequestReadCnt() {
		return requestReadCnt;
	}
	public void setRequestReadCnt(int requestReadCnt) {
		this.requestReadCnt = requestReadCnt;
	}
	
	@Override
	public String toString() {
		return "RepairRequestVO [requestNum=" + requestNum + ", requestTitle=" + requestTitle + ", requestContent="
				+ requestContent + ", requestName=" + requestName + ", requestCreate=" + requestCreate
				+ ", requestReadCnt=" + requestReadCnt + ", stuNum=" + stuNum + ", stuYear=" + stuYear + ", depName="
				+ depName + ", requestStatus=" + requestStatus + "]";
	}
	
    
}
