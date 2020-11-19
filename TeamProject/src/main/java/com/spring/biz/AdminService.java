package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.LectureAInfoVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.StatusRegVO;
import com.spring.biz.vo.StatusVO;
import com.spring.biz.vo.StuGradeVO;
import com.spring.biz.vo.StudentVO;

public interface AdminService {
	//학적변동 신청 리스트
	List<StatusRegVO> statusRegList();
	//학적변동 승인여부 변경
	int updateStatus(String regNum);
	//학적변동 신청한 학생의 학적상태 변경
	int updateStudentStatus(String regNum);
	//학생 리스트
	List<MyInfoVO> selectStudentList(MyInfoVO myInfoVO);
	
	//단과대학 리스트
	List<CollegeVO> selectCollegeList();
	//전체 전공리스트
	List<DepVO> selectStuDep();
	//대학별 전공리스트
	List<DepVO> selectCDepList(CollegeVO collegeVO);
	//학적상태 리스트
	List<StatusVO> selectStatusList();
	
	//(성적입력)과목리스트
	List<LectureAInfoVO> selectLecListG();
	//과목별 수강 학생 리스트
	List<StuGradeVO> lecStudentList(String lecCode);
	//성적 업데이트
	int updateGrade(StuGradeVO stuGradeVO);
	
	
}




















