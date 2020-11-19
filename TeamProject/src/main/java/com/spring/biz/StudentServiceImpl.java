package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.ApplyManagementVO;
import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.LecTimeVO;
import com.spring.biz.vo.LectureAInfoVO;
import com.spring.biz.vo.LectureVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MenuVO;
import com.spring.biz.vo.MyGradeVO;
import com.spring.biz.vo.MyTimetableVO;
import com.spring.biz.vo.RepairRequestVO;
import com.spring.biz.vo.SemGradeDetailVO;
import com.spring.biz.vo.SemGradeVO;
import com.spring.biz.vo.StatusRegVO;
import com.spring.biz.vo.StuTTCartVO;
import com.spring.biz.vo.StuTTVO;
import com.spring.biz.vo.StudentVO;

@Service("studentService") 
public class StudentServiceImpl implements StudentService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	//학적변동 신청
	@Override
	public int changeStatus(StatusRegVO statusRegVO) {
		return sqlSession.insert("changeStatus", statusRegVO);
	}
	//학적변동 신청중 확인
	@Override
	public StatusRegVO checkComfirm(int stuNum) {
		return sqlSession.selectOne("checkComfirm", stuNum);
	}
	
	@Override
	public List<LectureAInfoVO> selectLecTTList(LectureAInfoVO lectureAInfoVO) {
		return sqlSession.selectList("selectLecTTList", lectureAInfoVO);
	}
	@Override
	public List<LecTimeVO> selectLecTimeList() {
		return sqlSession.selectList("selectLecTimeList");
	}
	//강의목록(전체)
	@Override
	public List<LectureVO> selectLectureList(LectureVO lectureVO) {
		return sqlSession.selectList("selectLectureList", lectureVO);
	}
	//고장-수리 신청 글쓰기 
	@Override
	public int insertRepairRequest(RepairRequestVO repairRequestVO) {
		
		return  sqlSession.insert("insertRepairRequest", repairRequestVO);
	}
	//고장수리 글 목록
	@Override
	public List<RepairRequestVO> selectRepairRequest(RepairRequestVO repairRequestVO) {
		
		return  sqlSession.selectList("selectRepairRequest", repairRequestVO);
	}
	//글 상세보기
	@Override
	public RepairRequestVO repairRequestDetail(RepairRequestVO repairRequestVO) {
		
		return sqlSession.selectOne("repairRequestDetail", repairRequestVO);
	}
	//글 조회수
	@Override
	public int upDateReadCnt(RepairRequestVO repairRequestVO) {
		
		return sqlSession.update("upDateReadCnt", repairRequestVO);
	}
	//예비수강신청 
	@Override
	public int insertTtCart(StuTTCartVO stuTTCartVO) {
		return sqlSession.insert("insertTtCart", stuTTCartVO);
	}
	//예비수강신청 현재인원 업데이트
	@Override
	public int updateAppNum(LecTTVO lecTTVO) {
		return sqlSession.update("updateAppNum", lecTTVO);
	}
	//예비수강신청 목록
	@Override
	public List<StuTTCartVO> selectCartList(int stuNum) {
		return sqlSession.selectList("selectCartList", stuNum);
	}
	//예비수강신청 취소(과목빼기)
	@Override
	public int deleteTtCart(StuTTCartVO stuTTCartVO) {
		return sqlSession.delete("deleteTtCart", stuTTCartVO);
	}
	//예비수강신청 현재인원 업데이트(마이너스)
	@Override
	public int minusAppNum(LecTTVO lecTTVO) {
		return sqlSession.update("minusAppNum", lecTTVO);
	}
	//수강신청
	@Override
	public int insertStuTT(StuTTVO stuTTVO) {
		return sqlSession.insert("insertStuTT", stuTTVO);
	}
	@Override
	public int insertGrade(StuTTVO stuTTVO) {
		return sqlSession.insert("insertGrade", stuTTVO);
	}
	//수강신청목록
	@Override
	public List<StuTTVO> selectStuTTList(int stuNum) {
		return sqlSession.selectList("selectStuTTList", stuNum);
	}
	//수강취소
	@Override
	public int deleteStuTT(StuTTVO stuTTVO) {
		return sqlSession.delete("deleteStuTT", stuTTVO);
	}
	@Override
	public int deleteGrade(StuTTVO stuTTVO) {
		return sqlSession.delete("deleteGrade", stuTTVO);
	}
	
	//전과 , 복수전공 신청
	@Override
	public int insertApplyManagement(ApplyManagementVO applyManagementVO) {
		return sqlSession.insert("insertApplyManagement", applyManagementVO);
	}
	//신청 취소 
	@Override
	public int deleteMajorList(ApplyManagementVO applyManagementVO) {
		return sqlSession.delete("deleteMajorList", applyManagementVO);
	}

	@Override
	public List<ApplyManagementVO> selectDoubleMajorList(ApplyManagementVO applyManagementVO) {
		return sqlSession.selectList("selectDoubleMajorList", applyManagementVO);
	}
	@Override
	public int deleteDoubleMajorList(ApplyManagementVO applyManagementVO) {
		return 	sqlSession.delete("deleteDoubleMajorList", applyManagementVO);
	}
	@Override
	public int updateMajorStudent(StudentVO studentVO) {
		return sqlSession.update("updateMajorStudent", studentVO);
	}
	@Override
	public int updateDoubleMajorStudent(StudentVO studentVO) {
		
		return sqlSession.update("updateDoubleMajorStudent", studentVO);
	}
	@Override
	public int majorAplicationConfirm(ApplyManagementVO applyManagementVO) {
		return sqlSession.selectOne("majorAplicationConfirm", applyManagementVO);
	}
	

	@Override
	public List<MyTimetableVO> selectMytimetable(MyTimetableVO myTimetableVO) {
		return sqlSession.selectList("selectMyTimetable", myTimetableVO);
	}
	//현재학기
	@Override
	public int selectSemester(int nowDate) {
		return sqlSession.selectOne("selectSemester", nowDate);
	}
	@Override
	public int getRepairListCnt(RepairRequestVO repairRequestVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getRepairListCnt", repairRequestVO);
	}
	@Override
	public List<MyGradeVO> selectMyGrade(MyGradeVO myGradeVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectMyGrade", myGradeVO);
	}
	@Override
	public List<MyGradeVO> groupMyGrade(MyGradeVO myGradeVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("groupMyGrade", myGradeVO);
	}
	@Override
	public MyGradeVO AllMyInfo(MyGradeVO myGradeVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("AllMyInfo", myGradeVO);
	}
	@Override
	public int countDep(int stuNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countDep", stuNum);
	}
	@Override
	public List<SemGradeVO> selectSemGrade(MemberVO memberVO) {
		return sqlSession.selectList("selectSemGrade", memberVO);
	}
	@Override
	public List<SemGradeVO> selectSemLecCredit(MemberVO memberVO) {
		return sqlSession.selectList("selectSemLecCredit", memberVO);
	}
	@Override
	public SemGradeVO selectTotalGrade(MemberVO memberVO) {
		return sqlSession.selectOne("selectTotalGrade", memberVO);
	}
	@Override
	public List<SemGradeDetailVO> selectGradeDetail(SemGradeDetailVO semGradeDetailVO) {
		return sqlSession.selectList("selectGradeDetail", semGradeDetailVO);
	}
	@Override
	public int updateRepiarRequest(RepairRequestVO repairRequestVO) {
		
		return sqlSession.update("updateRepiarRequest", repairRequestVO);
	}
	
}












