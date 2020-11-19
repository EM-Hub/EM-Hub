package com.spring.biz.vo;

public class BoardCommentVO {

	private int commentNum;
	private int boardNum;
	private String commentContent;
	private String commentCreateDate;
	private String commentWriter;
	
	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentCreateDate() {
		return commentCreateDate;
	}

	public void setCommentCreateDate(String commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}


}










