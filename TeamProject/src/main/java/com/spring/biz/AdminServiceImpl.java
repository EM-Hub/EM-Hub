package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.LectureAInfoVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MenuVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.StatusRegVO;
import com.spring.biz.vo.StatusVO;
import com.spring.biz.vo.StuGradeVO;
import com.spring.biz.vo.StudentVO;

@Service("adminService") 
public class AdminServiceImpl implements AdminService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	//학적 변동 신청 리스트
	@Override
	public List<StatusRegVO> statusRegList() {
		return sqlSession.selectList("statusRegList");
	}
	//학적변동 승인여부 변경
	@Override
	public int updateStatus(String regNum) {
		
		return sqlSession.update("updateStatus", regNum);
	}
	//학적변동 신청한 학생의 학적상태 변경
	@Override
	public int updateStudentStatus(String regNum) {
		return sqlSession.update("updateStudentStatus", regNum);
	}
	//학생 리스트
	@Override
	public List<MyInfoVO> selectStudentList(MyInfoVO myInfoVO) {
		return sqlSession.selectList("selectStudentList", myInfoVO);
	}
	@Override
	public List<CollegeVO> selectCollegeList() {
		return sqlSession.selectList("selectCollegeList");
	}
	@Override
	public List<DepVO> selectCDepList(CollegeVO collegeVO) {
		return sqlSession.selectList("selectCDepList", collegeVO);
	}
	@Override
	public List<DepVO> selectStuDep() {
		return sqlSession.selectList("selectStuDep");
	}
	@Override
	public List<StatusVO> selectStatusList() {
		return sqlSession.selectList("selectStatusList");
	}
	//(성적입력)과목리스트
	@Override
	public List<LectureAInfoVO> selectLecListG() {
		return sqlSession.selectList("selectLecListG");
	}
	@Override
	public List<StuGradeVO> lecStudentList(String lecCode) {
		return sqlSession.selectList("lecStudentList", lecCode);
	}
	//성적입력
	@Override
	public int updateGrade(StuGradeVO stuGradeVO) {
		return sqlSession.update("updateGrade", stuGradeVO);
	}
	
	
	
}












