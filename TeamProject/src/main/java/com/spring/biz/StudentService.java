package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.ApplyManagementVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.LecTimeVO;
import com.spring.biz.vo.LectureAInfoVO;
import com.spring.biz.vo.LectureVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MyGradeVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.MyTimetableVO;
import com.spring.biz.vo.RepairRequestVO;
import com.spring.biz.vo.SemGradeDetailVO;
import com.spring.biz.vo.SemGradeVO;
import com.spring.biz.vo.StatusRegVO;
import com.spring.biz.vo.StuTTCartVO;
import com.spring.biz.vo.StuTTVO;
import com.spring.biz.vo.StudentVO;

public interface StudentService {
	//휴학,복학 신청
	int changeStatus(StatusRegVO statusRegVO);
	//휴복학 신청중 확인
	StatusRegVO checkComfirm(int stuNum);
	//수강신청(예비포함) 과목목록
	List<LectureAInfoVO> selectLecTTList(LectureAInfoVO lectureAInfoVO);
	//수강신청 시간/강의실조회
	List<LecTimeVO> selectLecTimeList();
	//현재학기
	int selectSemester(int nowDate);
	//예비수강신청 과목담기
	int insertTtCart(StuTTCartVO stuTTCartVO);
	int updateAppNum(LecTTVO lecTTVO);
	//예비수강신청 과목빼기
	int deleteTtCart(StuTTCartVO stuTTCartVO);
	int minusAppNum(LecTTVO lecTTVO);
	//예비수강신청(바구니) 목록
	List<StuTTCartVO> selectCartList(int stuNum);
	//수강신청
	int insertStuTT(StuTTVO stuTTVO);
	int insertGrade(StuTTVO stuTTVO);
	//수강신청목록
	List<StuTTVO> selectStuTTList(int stuNum);
	//수강취소
	int deleteStuTT(StuTTVO stuTTVO);
	int deleteGrade(StuTTVO stuTTVO);
	
	
	//강의 목록 (전체과목)
	List<LectureVO> selectLectureList(LectureVO lectureVO);
	//고장-수리신청
	int insertRepairRequest(RepairRequestVO repairRequestVO);
	//고장 글 목록 리스트
	List<RepairRequestVO> selectRepairRequest(RepairRequestVO repairRequestVO);
	//고장 글 상세보기 
	RepairRequestVO repairRequestDetail(RepairRequestVO repairRequestVO);
	//조회수 
	int upDateReadCnt(RepairRequestVO repairRequestVO);
	//글총갯수
	int getRepairListCnt(RepairRequestVO repairRequestVO);
	
	//전과 /복수전공 신청 
	int insertApplyManagement(ApplyManagementVO applyManagementVO);
	//전체 신청목록
	List<ApplyManagementVO> selectDoubleMajorList(ApplyManagementVO applyManagementVO);
	//전과신청삭제
	int deleteMajorList(ApplyManagementVO applyManagementVO);
	//복수전공신청삭제
	int deleteDoubleMajorList(ApplyManagementVO applyManagementVO);
	//둘중에 하나 신청
	int majorAplicationConfirm(ApplyManagementVO applyManagementVO);
	//처리상태 - 승인 시 학생의 전과 업데이트
	int updateMajorStudent(StudentVO studentVO);
	//처리상태 - 승인 시 학생의 복수전공 업데이트 
	int  updateDoubleMajorStudent(StudentVO studentVO);
	//myTimetable 조회
	List<MyTimetableVO> selectMytimetable(MyTimetableVO myTimetableVO);
	
	//과목별
	List<MyGradeVO> selectMyGrade(MyGradeVO myGradeVO);
	
	//학기별
	List<MyGradeVO> groupMyGrade(MyGradeVO myGradeVO);
	
	//종합
	
	MyGradeVO AllMyInfo (MyGradeVO myGradeVO);
	
	int countDep(int stuNum);
	List<SemGradeVO> selectSemGrade(MemberVO memberVO);
	List<SemGradeVO> selectSemLecCredit(MemberVO memberVO);
	SemGradeVO selectTotalGrade(MemberVO memberVO);
	
	List<SemGradeDetailVO> selectGradeDetail(SemGradeDetailVO semGradeDetailVO);
	
	

	//고장게시글 처리상태 업데이트
		int updateRepiarRequest(RepairRequestVO repairRequestVO);
}




















