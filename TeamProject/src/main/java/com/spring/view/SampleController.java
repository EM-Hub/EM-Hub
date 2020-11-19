package com.spring.view;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.CommonService;
import com.spring.biz.MemberService;
import com.spring.biz.MenuService;
import com.spring.biz.vo.BoardVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MenuVO;
import com.spring.biz.vo.MyInfoVO;


@Controller
public class SampleController {
	@Resource(name = "menuService")
	MenuService menuService;
	@Resource(name = "memberService")
	MemberService memberService;
	@Resource(name = "commonService")
	CommonService commonService;
	
	
	private int lecWeek;
	
	@RequestMapping(value = "/sampleMain.do")
	public String sampleMain() {
		return "sample/sampleMain";
	}
	@RequestMapping(value = "/loginPage.do")
	public String loginPage() {
		return "sample/loginPage";
	}
	
	//메인페이지
	@RequestMapping(value = "/mainPage.do")
	public String mainPage(Model model, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO, HttpSession session) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		
		if(session.getAttribute("loginInfo") != null) {
			myInfoVO.setStuNum(vo.getMemId());
			model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		}
		
		List<BoardVO> list = commonService.board3();
		model.addAttribute("board", list);
		
		menuSideDetailVO.setMemGrade(vo.getMemGrade());
		
		session.setAttribute("mainMenu", menuService.mainMenu(menuSideDetailVO));
		
		return "main/mainContent";
	}
	//메뉴 사이드 바 Ajax
	@ResponseBody
	@RequestMapping(value = "/selectSideMenu.do")
	public List<MenuSideVO> selectSideMenu(MenuSideDetailVO menuSideDetailVO) {
		return menuService.sideMenu(menuSideDetailVO);
	}
	
	
	//메인 메뉴 사이드 타이틀
		@ResponseBody
		@RequestMapping(value = "/selectMainMenuSide.do")
		public List<MenuVO> selectMainMenuSide(MenuSideDetailVO menuSideDetailVO) {
			return menuService.mainMenuSide(menuSideDetailVO);
	}

	@ResponseBody
	@RequestMapping(value = "/selectMenuDetail1.do")
	public List<MenuSideDetailVO> selectMenuDetail1(MenuSideDetailVO menuSideDetailVO) {
		return menuService.sideDetailMenu(menuSideDetailVO);
	}
	
	
	//클릭 한 메뉴 이름
		@ResponseBody
		@RequestMapping(value = "/clickMenuTitle.do")
			public List<MenuSideDetailVO> clickMenuTitle(MenuSideDetailVO menuSideDetailVO) {
			return menuService.menuLocation(menuSideDetailVO);
	}
	
}










