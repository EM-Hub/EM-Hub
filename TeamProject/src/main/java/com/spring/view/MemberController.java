package com.spring.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.MemberService;
import com.spring.biz.MenuService;
import com.spring.biz.vo.EmpInfoVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MyInfoVO;

@Controller
public class MemberController {
	@Resource(name = "memberService")
	MemberService memberService;
	@Resource(name = "menuService")
	MenuService menuService;

	// 로그인
	@ResponseBody
	@RequestMapping(value = "/loginMember.do")
	public String loginMember(MemberVO memberVO, HttpSession session) {
		System.out.println(memberVO + "~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 로그인 실행
		MemberVO loginInfo = memberService.loginMember(memberVO);
		// 세션에 로그인 데이터 저장
		session.setAttribute("loginInfo", loginInfo);

		String result = "success";

		if (loginInfo == null) {
			result = "fail";
		}

		return result;
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");

		return "redirect:sampleMain.do";
	}

	// 내정보 보기(학생)
	@RequestMapping(value = "/studentMyInfo.do")
	public String studentMyInfo(MyInfoVO myInfoVO, Model model, HttpSession session,
			MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));

		model.addAttribute("menuLocation", menuService.menuLocation(menuSideDetailVO));

		return "student/myInfo";
	}
	
	// 내정보 보기(관리자)
	@RequestMapping(value = "/adminMyInfo.do")
	public String adminMyInfo(MenuSideDetailVO menuSideDetailVO, HttpSession session, EmpInfoVO empInfoVO, Model model) {

		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		empInfoVO.setEmpNo(vo.getMemId());
		System.out.println(empInfoVO.getEmpNo());
		model.addAttribute("empInfo", memberService.adminMyInfo(empInfoVO));
		
		return "admin/adminInfo";
	}
	
	// 내정보수정 페이지
	@RequestMapping(value = "/updateAdminMyInfo.do")
	public String updateAdminMyInfo(MenuSideDetailVO menuSideDetailVO, HttpSession session, EmpInfoVO empInfoVO, Model model) {
		
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		empInfoVO.setEmpNo(vo.getMemId());
		System.out.println(empInfoVO.getEmpNo());
		model.addAttribute("empInfo", memberService.adminMyInfo(empInfoVO));

		return "admin/updateAdminMyInfo";
	}
	
		

	// 내정보수정 페이지
	@RequestMapping(value = "/updateMyInfoPage.do")
	public String updateMyInfo(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));

		model.addAttribute("menuLocation", menuService.menuLocation(menuSideDetailVO));

		return "student/updateMyInfo";
	}

	// 내정보 수정(학생)
	@ResponseBody
	@RequestMapping(value = "/updateMyInfo.do")
	public int updateMyInfo(MemberVO memberVO, HttpSession session) {
		int update = memberService.updateMyInfo(memberVO);

		return update;
	}
	
	// 내정보 수정(관리자)
	@ResponseBody
	@RequestMapping(value = "/updateMyInfo1.do")
	public int updateMyInfo1(MemberVO memberVO, HttpSession session) {
		int update = memberService.updateMyInfo(memberVO);

		return update;
	}


	// 비밀번호 검사 페이지
	@RequestMapping(value = "/passwordConfirmPage.do")
	public String passwordConfirmPage(MenuSideDetailVO menuSideDetailVO) {
		return "student/passwordConfirmPage";

	}

	// 비밀번호 검사
	@ResponseBody
	@RequestMapping(value = "/passwordConfirm.do")
	public MemberVO passwordConfirm(HttpSession session, MenuSideDetailVO menuSideDetailVO, MemberVO memberVO) {
			
			return memberService.passwordConfirm(memberVO);
	}	
	//비밀번호 변경페이지
		@RequestMapping(value = "/passwordChangePage.do")
		public String passwordChangePage(MenuSideDetailVO menuSideDetailVO, MemberVO memberVO) {
			return "student/passwordChangePage";
	}
	//비밀번호 변경
	@RequestMapping(value = "/passwordChange.do")
	public String passwordChange(HttpSession session, MenuSideDetailVO menuSideDetailVO, MemberVO memberVO, String memPassword1, String memPassword2) {
		memberVO.setMemPassword(memPassword1);
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		memberVO.setMemId(vo.getMemId());
		
		memberService.changePassword(memberVO);
		return "redirect:mainPage.do";
	}

}
