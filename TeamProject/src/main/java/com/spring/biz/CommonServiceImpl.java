package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.BoardCategoryListVO;
import com.spring.biz.vo.BoardCommentVO;
import com.spring.biz.vo.BoardVO;
import com.spring.biz.vo.CalendarVO;

@Service("commonService") 
public class CommonServiceImpl implements CommonService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> boardList(BoardVO boardVO) {
		return sqlSession.selectList("boardList", boardVO);
	}

	@Override
	public BoardCategoryListVO categoryName(int categoryNum) {
		return sqlSession.selectOne("categoryName", categoryNum);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return sqlSession.insert("insertBoard", boardVO);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) {
		return sqlSession.selectOne("detail", boardVO);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return sqlSession.delete("deleteBoard", boardVO);
	}

	@Override
	public int readCnt(int boardNum) {
		return sqlSession.update("readCnt", boardNum);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlSession.update("updateBoard", boardVO);
	}

	@Override
	public int insertComment(BoardCommentVO boardCommentVO) {
		return sqlSession.insert("insertComment1", boardCommentVO);
	}

	@Override
	public List<BoardCommentVO> selectComment(int boardNum) {
		return sqlSession.selectList("selectComment", boardNum);
	}

	@Override
	public int commentCnt(int boardNum) {
		return sqlSession.update("commentCnt", boardNum);
	}

	@Override
	public int insertBoard1(BoardVO boardVO) {
		return sqlSession.insert("insertBoard1", boardVO);
	}

	@Override
	public int getBoardListCnt(BoardVO boardVO) {
		return sqlSession.selectOne("getBoardListCnt", boardVO);
	}
	
	@Override
	public int updateComment(BoardCommentVO boardCommentVO) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateComment", boardCommentVO);
	}

	@Override
	public int deleteComment(int CommentNum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("deleteComment", CommentNum);
	}
	
	@Override
	public int insertCalendar(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertCalendar", calendarVO);
	}

	@Override
	public List<CalendarVO> selectCalendar() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectCalendar");
	}
	
	@Override
	public List<CalendarVO> selectCalendar1(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectCalendar1", calendarVO);
	}

	@Override
	public int deleteCalendar(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		return sqlSession.delete("deleteCalendar", calendarVO);
	}

	@Override
	public int commentCnt1(int boardNum) {
		// TODO Auto-generated method stub
		return sqlSession.update("commentCnt1", boardNum);
	}
	
	@Override
	public List<BoardVO> board3() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board3");
	}
	
}












