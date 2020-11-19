package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.ApplyManagementVO;
import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.EmpVO;
import com.spring.biz.vo.ExpelVO;
import com.spring.biz.vo.FacUseListVO;
import com.spring.biz.vo.FacilityVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.LecTimeVO;
import com.spring.biz.vo.LectureVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MyTimetableVO;
import com.spring.biz.vo.ProbationVO;
import com.spring.biz.vo.TimetableVO;

public interface EmpService {
	//강의 등록
	int insertLec(LectureVO lectureVO);
	//단과대 정보 갖고오기
	List<CollegeVO> selectColList();
	//단과대별 학과정보 갖고오기
	List<DepVO> selectDepList(DepVO depVO);
	//교직원정보 갖고오기
	List<EmpVO> selectEmpList(EmpVO empVO);
	//등록된강의리스트 갖고오기
	List<LectureVO> selectLectureList(LectureVO lectureVO);
	//강의삭제
	int deleteLec(LectureVO lectureVO);
	//강의정보 들고오기
	LectureVO selectLecture(LectureVO lectureVO);
	//강의정보 업데이트
	int updateLectureInfo(LectureVO lectureVO);
	//시간표 정보 가져오기
	List<TimetableVO> selectTimetable();
	//facLoc가져오기
	List<FacilityVO> selectFacLoc();
	//facLocDetail가져오기
	List<FacilityVO> selectFacDetail(FacilityVO facilityVO);
	//강의 오픈
	int openLecture(LecTTVO lecTTVO, List<LecTimeVO> list);
	//시간표 정보 가져오기
	List<TimetableVO> selectTT();
	//시설사용목록 갖고오기
	List<FacUseListVO> selectFacUseList(FacUseListVO facUseListVO);
	//시설사용 신청
	int insertFacUse(FacUseListVO facUseListVO);
	//시설사용목록A 갖고오기
	List<FacUseListVO> selectFacUseLista(FacUseListVO facUseListVO);
	//시설 사용 철회하기
	int deleteFacUse(FacUseListVO facUseListVO);
	//학사경고 등록
	int insertProbation(ProbationVO probationVO);
	//제적등록
	int insertExpel(ExpelVO expelVO);
	
	//전/부 신청 관리 목록
	List<ApplyManagementVO> selectMajorList();
	
	int updateApplyStudent(ApplyManagementVO applyManagementVO);
	
	int updateStudentExpel(int stuNum);
}




















