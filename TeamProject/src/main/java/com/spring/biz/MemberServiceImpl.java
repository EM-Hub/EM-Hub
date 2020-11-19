package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.EmpInfoVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.StudentVO;

@Service("memberService") 
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		return sqlSession.selectOne("loginMember", memberVO);
	}

	@Override
	public MyInfoVO studentMyInfo(MyInfoVO myInfoVO) {
		return sqlSession.selectOne("studentMyInfo", myInfoVO);
	}
	
	@Override
	public int updateMyInfo(MemberVO memberVO) {
		return sqlSession.update("updateMyInfo", memberVO);
	}

	@Override
	public MemberVO passwordConfirm(MemberVO memberVO) {
	
		return 	sqlSession.selectOne("passwordConfirm", memberVO);
	}

	@Override
	public int changePassword(MemberVO memberVO) {

		return sqlSession.update("changePassword", memberVO);
	}

	@Override
	public String selectMemName(MemberVO memberVO) {
		return sqlSession.selectOne("selectMemberName", memberVO);
	}

	@Override
	public String selectMemberGrade(MemberVO memberVO) {
		return sqlSession.selectOne("selectMemberGrade", memberVO);
	}

	@Override
	public EmpInfoVO adminMyInfo(EmpInfoVO empInfoVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("adminMyInfo", empInfoVO);
	}

	@Override
	public List<MyInfoVO> majorStudentInfo(MyInfoVO myInfoVO) {
		return  sqlSession.selectList("majorStudentInfo", myInfoVO);
	}
}












