package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.spring.biz.vo.StudentVO;
import com.spring.biz.vo.TimetableVO;

@Service("empService") 
public class EmpServiceImpl implements EmpService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertLec(LectureVO lectureVO) {
		return sqlSession.insert("insertLec", lectureVO);
	}

	@Override
	public List<CollegeVO> selectColList() {
		return sqlSession.selectList("selectColList");
	}

	@Override
	public List<DepVO> selectDepList(DepVO depVO) {
		return sqlSession.selectList("selectDepList", depVO);
	}

	@Override
	public List<EmpVO> selectEmpList(EmpVO empVO) {
		return sqlSession.selectList("selectEmpList", empVO);
	}

	@Override
	public List<LectureVO> selectLectureList(LectureVO lectureVO) {
		return sqlSession.selectList("selectLecList", lectureVO);
	}

	@Override
	public int deleteLec(LectureVO lectureVO) {
		return sqlSession.delete("deleteLec", lectureVO);
	}

	@Override
	public LectureVO selectLecture(LectureVO lectureVO) {
		return sqlSession.selectOne("selectLec", lectureVO);
	}

	@Override
	public int updateLectureInfo(LectureVO lectureVO) {
		return sqlSession.update("updateLectureInfo", lectureVO);
	}

	@Override
	public List<TimetableVO> selectTimetable() {
		return sqlSession.selectList("selectTimetable");
	}

	@Override
	public List<FacilityVO> selectFacLoc() {
		return sqlSession.selectList("selectFacLoc");
	}

	@Override
	public List<FacilityVO> selectFacDetail(FacilityVO facilityVO) {
		return sqlSession.selectList("selectFacDetail", facilityVO);
	}

	@Override
	public int openLecture(LecTTVO lecTTVO, List<LecTimeVO> list) {
		int result = 0;
		try {
			int result1 = sqlSession.insert("insertLecTT", lecTTVO);
			int result2 = sqlSession.insert("insertLecTime", list);
			result =  result1 + result2;
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	@Override
	public List<TimetableVO> selectTT() {
		return sqlSession.selectList("selectTimetable");
	}

	@Override
	public List<FacUseListVO> selectFacUseList(FacUseListVO facUseListVO) {
		return sqlSession.selectList("selectFacUseList", facUseListVO);
	}

	@Override
	public int insertFacUse(FacUseListVO facUseListVO) {
		return sqlSession.insert("insertFacUse", facUseListVO);
	}

	@Override
	public List<FacUseListVO> selectFacUseLista(FacUseListVO facUseListVO) {
		return sqlSession.selectList("selectFacUseLista", facUseListVO);
	}

	@Override
	public int deleteFacUse(FacUseListVO facUseListVO) {
		return sqlSession.delete("deleteFacUse", facUseListVO);
	}

	@Override
	public int insertProbation(ProbationVO probationVO) {
		return sqlSession.insert("insertProbation", probationVO);
	}
	
	@Override
	public List<ApplyManagementVO> selectMajorList() {
		
		return sqlSession.selectList("selectMajorList");
	}

	@Override
	public int updateApplyStudent(ApplyManagementVO applyManagementVO) {
		
		return sqlSession.update("updateApplyStudent", applyManagementVO);
	}

	@Override
	public int insertExpel(ExpelVO expelVO) {
		return sqlSession.insert("insertExpel", expelVO);
	}

	@Override
	public int updateStudentExpel(int stuNum) {
		return sqlSession.update("updateStudentExpel", stuNum);
	}


	
}












