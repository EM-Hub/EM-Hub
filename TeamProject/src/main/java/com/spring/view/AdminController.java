



package com.spring.view;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.AdminService;
import com.spring.biz.MemberService;
import com.spring.biz.MenuService;
import com.spring.biz.StudentService;
import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.StatusRegVO;
import com.spring.biz.vo.StudentVO;
import com.spring.biz.vo.StuGradeVO;

@Controller
public class AdminController {
	@Resource(name = "memberService")
	MemberService memberService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "adminService")
	AdminService adminService;
	@Resource(name = "menuService")
	MenuService menuService;
	
	//학적변동 신청리스트페이지
	@RequestMapping(value = "/statusRegList.do")
	public String statusRegList(Model model, MenuSideDetailVO menuSideDetailVO) {
		
		model.addAttribute("statusRegList", adminService.statusRegList());
		
		return "admin/statusRegList";
	}
	//학적변동 승인
	@RequestMapping(value = "/updateStatus.do")
	public String updateStatus(String[] regNum, MenuSideDetailVO menuSideDetailVO) {
		//regNum이 담긴 배열로 service실행. -> 승인여부 변경
		for(int i = 0; i < regNum.length; i++) {
			adminService.updateStatus(regNum[i]);
		};
		//학적변동 신청한 학생의 학적상태 변경
		for(int i = 0; i < regNum.length; i++) {
			adminService.updateStudentStatus(regNum[i]);
		};
		return "redirect:statusRegList.do?mainNum=8&sideNum=23";
	}
	//학생관리 -> 학생조회
	@RequestMapping(value = "/studentList.do")
	public String studentList(MenuSideDetailVO menuSideDetailVO, Model model, MyInfoVO myInfoVO) {
		
		model.addAttribute("studentList", adminService.selectStudentList(myInfoVO));
		model.addAttribute("collegeList", adminService.selectCollegeList());
		model.addAttribute("depList", adminService.selectStuDep());
		model.addAttribute("statusList", adminService.selectStatusList());
		return "admin/studentList";
	}
	//학생 상세정보 보기
	@RequestMapping(value = "/studentInfo.do")
	public String studentInfo(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO) {
		
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		model.addAttribute("menuLocation", menuService.menuLocation(menuSideDetailVO));

		return "admin/studentInfo";
	}
	//학생 검색
	@ResponseBody
	@RequestMapping(value = "/searchStudent.do")
	public List<MyInfoVO> searchStudent(MyInfoVO myInfoVO, String searchValue) {
		//검색어 숫자, 문자 구분(학번 or 이름)
		try {
			int stuNum = Integer.parseInt(searchValue);
			myInfoVO.setStuNum(stuNum);
		} catch (Exception e) {
			myInfoVO.setStuName(searchValue);
		}
		
		return adminService.selectStudentList(myInfoVO);
	}
	//조건이 있는 학생조회
	@ResponseBody
	@RequestMapping(value = "/stuList.do")
	public List<MyInfoVO> stuList(MyInfoVO myInfoVO) {
		return adminService.selectStudentList(myInfoVO);
	}
	//학생관리 -> 전체 선택 시 전체 과 list
	@ResponseBody
	@RequestMapping(value = "/selectStuDep.do")
	public List<DepVO> selectStuDep() {
		
		return adminService.selectStuDep();
	}
	//학생관리 -> 단과대학 선택 시 각 대학의 과 list
	@ResponseBody
	@RequestMapping(value = "/selectDep.do")
	public List<DepVO> selectDep(CollegeVO collegeVO) {
		
		return adminService.selectCDepList(collegeVO);
	}
	
	//학생관리 -> 성적입력페이지
	@RequestMapping(value = "/insertGradePage.do")
	public String insertGradePage(Model model, MenuSideDetailVO menuSideDetailVO) {
		model.addAttribute("lecList", adminService.selectLecListG());
		
		return "admin/insertGrade";
	}
	
	//성적관리 -> 선택한 과목의 학생리스트
	@ResponseBody
	@RequestMapping(value = "/lecStudentList.do")
	public List<StuGradeVO> lecStudentList(String lecCode) {
		
		return adminService.lecStudentList(lecCode);
	}
	//성적등록
	@RequestMapping(value = "/updateGrade.do")
	public String updateGrade(int[] stuNum, int[] gradeNum, String lecTtCode, Model model) {
		System.out.println("===========================================================================================");
		StuGradeVO stuGradeVO = new StuGradeVO();
		
		for(int i = 0; i < gradeNum.length; i++) {
			stuGradeVO.setGradeNum(gradeNum[i]);
			stuGradeVO.setStuNum(stuNum[i]);
			stuGradeVO.setLecTtCode(lecTtCode);
			
			adminService.updateGrade(stuGradeVO);
		};
		
		model.addAttribute("mainNum", 8);
		model.addAttribute("sideNum", 22);
		
		return "redirect:insertGradePage.do";
	}
	
	
}