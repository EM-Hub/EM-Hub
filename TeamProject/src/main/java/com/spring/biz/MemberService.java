package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.EmpInfoVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.StudentVO;

public interface MemberService {
	MemberVO loginMember(MemberVO memberVO);
	//내정보 보기
	MyInfoVO studentMyInfo(MyInfoVO myInfoVO);
	//내정보 수정
	int updateMyInfo(MemberVO memberVO);
	//비밀번호 확인
	MemberVO passwordConfirm(MemberVO memberVO);
	//비밀번호 변경
	int changePassword(MemberVO memberVO);
	//멤버 이름 조회
	String selectMemName(MemberVO memberVO);
	//멤버 등그,ㅂ 조회
	String selectMemberGrade(MemberVO memberVO);
	//내정보 보기(교수)
	EmpInfoVO adminMyInfo(EmpInfoVO empInfoVO);
	//신청한 학생의 정보
	List<MyInfoVO> majorStudentInfo(MyInfoVO myInfoVO);

	
}




















