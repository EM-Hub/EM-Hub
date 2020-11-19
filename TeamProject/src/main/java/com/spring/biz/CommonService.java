package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.BoardCategoryListVO;
import com.spring.biz.vo.BoardCommentVO;
import com.spring.biz.vo.BoardVO;
import com.spring.biz.vo.CalendarVO;

public interface CommonService {

	//-----------게시판------------------

	//보드게시판에서 카테고리 이름빼오기
	BoardCategoryListVO categoryName (int categoryNum);
	
	//게시판 리스트 뽑아오기
	List<BoardVO> boardList(BoardVO boardVO);
	
	//글쓰기
	int insertBoard(BoardVO boardVO);
	
	//상세보기
	BoardVO detail(BoardVO boardVO);
	
	//글삭제
	int deleteBoard(BoardVO boardVO);
	
	//조회수
	int readCnt(int boardNum);
	
	//글수정
	int updateBoard(BoardVO boardVO);
	
	//댓글입력
	int insertComment(BoardCommentVO boardCommentVO);
	
	//댓글 리스트 뽑아오기
	List<BoardCommentVO> selectComment(int boardNum);
	
	//댓글 총 갯수 출력
	int commentCnt(int boardNum);
	
	//댓글 총 갯수 출력 -1
		int commentCnt1(int boardNum);
	
	//답글
	int insertBoard1(BoardVO boardVO);
	
	//게시글 총 갯수 페이징처리
	int getBoardListCnt(BoardVO boardVO);

	// 댓글 수정
	int updateComment(BoardCommentVO boardCommentVO);
	
	// 댓글 삭제
	int deleteComment(int CommentNum);
	
	// ------------------------------------ 달력
	
	//입력
	int insertCalendar(CalendarVO calendarVO);
	//조회
	List<CalendarVO> selectCalendar();
	//조회
	List<CalendarVO> selectCalendar1(CalendarVO calendarVO);
	//삭제
	int deleteCalendar(CalendarVO calendarVO);
	//공지사항
	List<BoardVO> board3();
	
}




















