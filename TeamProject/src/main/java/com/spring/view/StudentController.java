package com.spring.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.AdminService;
import com.spring.biz.EmpService;
import com.spring.biz.MemberService;
import com.spring.biz.StudentService;
import com.spring.biz.vo.ApplyManagementVO;
import com.spring.biz.vo.CollegeVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.FacUseListVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.LecTimeVO;
import com.spring.biz.vo.LectureAInfoVO;
import com.spring.biz.vo.LectureVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
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
import com.spring.biz.vo.TimetableVO;

@Controller
public class StudentController {
	@Resource(name = "memberService")
	MemberService memberService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "empService")
	EmpService empService;
	@Resource(name = "adminService")
	AdminService adminService;
	
	//학적변동페이지 - 휴학신청안내 페이지
	@RequestMapping(value = "/loaGuide.do")
	public String loaGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/loaGuide";
	}		
	// 학적관리 - 복학신청안내
	@RequestMapping(value = "/returningToSchoolGuide.do")
	public String returningToSchoolGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/returningToSchoolGuide";
	}
	
	// 학적관리 - 자퇴안내페이지 
	@RequestMapping(value = "/dropOutGuide.do")
	public String dropOutGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/dropOutGuide";
	}
	
	// 교과과정 - 수강신청안내페이지
	@RequestMapping(value = "/lecGuide.do")
	public String lecGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/lecGuide";
	}
	
	// 교과과정 - 예비수강신청안내페이지
	@RequestMapping(value = "/spareLecGuide.do")
	public String spareLecGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/spareLecGuide";
	}
	
	// 대학생활 - 시설물안내페이지
	@RequestMapping(value = "/facilityGuide.do")
	public String facilityGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/facilityGuide";
	}

	// 학적관리 - 전과안내페이지
	@RequestMapping(value = "/majorGuide.do")
	public String majorGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/majorGuide";
	}

	// 학적관리 - 복수전공안내페이지
	@RequestMapping(value = "/doubleMajorGuide.do")
	public String doubleMajorGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/doubleMajorGuide";
	}
	// 내정보 - 졸업요건 안내페이지
	@RequestMapping(value = "/GraduatedGuide.do")
	public String GraduatedGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/GraduatedGuide";
	}
	// 취업정보 - 취업정보 안내페이지
	@RequestMapping(value = "/employmentGuide.do")
	public String employmentGuide(MenuSideDetailVO menuSideDetailVO) {
		return "student/employmentGuide";
	}
	
	
	
	//대학생활 -고장 수리 신청목록
	@RequestMapping(value = "/repairRequest.do")
	public String repairRequest(MenuSideDetailVO menuSideDetailVO,Model model, RepairRequestVO repairRequestVO, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range) {
		
		int listCnt = studentService.getRepairListCnt(repairRequestVO);
		repairRequestVO.pageInfo(page, range, listCnt);
		
		List<RepairRequestVO> list = studentService.selectRepairRequest(repairRequestVO);
		
		model.addAttribute("repairList", list);
		model.addAttribute("side", menuSideDetailVO);
		
		return "student/repairRequest";
	}

	//대학생활 -고장 수리신청 페이지
	@RequestMapping(value = "/repairRequestForm.do")
	public String repairRequestForm(MenuSideDetailVO menuSideDetailVO, HttpSession session, MyInfoVO myInfoVO,Model model,RepairRequestVO repairRequestVO) {
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
			
		return "student/repairRequestForm";
	}
	
	//대학생활 -고장 수리신청 하기
	@RequestMapping(value = "/insertRepairRequest.do")
	public String insertRepairRequest(MenuSideDetailVO menuSideDetailVO, HttpSession session, RepairRequestVO repairRequestVO, Model model, MyInfoVO myInfoVO) {
		
		studentService.insertRepairRequest(repairRequestVO);
		model.addAttribute("mainNum", 5);
		model.addAttribute("sideNum", 14);
		
		return "redirect:repairRequest.do";
	}
	//상세보기
	@RequestMapping(value = "/requestDetail.do")
	public String requestDetail(MenuSideDetailVO menuSideDetailVO,
								MyInfoVO myInfoVO,HttpSession session, RepairRequestVO repairRequestVO, Model model) {
			MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());	
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		model.addAttribute("requestDetail", studentService.repairRequestDetail(repairRequestVO));
		studentService.upDateReadCnt(repairRequestVO);
	
	return 	"student/requestDetail";
	}
	
	//교과과정 - 강의정보 - 강의목록
	@RequestMapping(value = "/lectureList.do")
	public String lectureSchedule(MenuSideDetailVO menuSideDetailVO, Model model, LectureVO lectureVO) {
		
		model.addAttribute("collegeList", adminService.selectCollegeList());
		model.addAttribute("depList", adminService.selectStuDep());
		model.addAttribute("LectureList", studentService.selectLectureList(lectureVO));
		
		return "student/lectureList";
	}
	//조건이 있는 강의목록 조회 & 과목 검색
	@ResponseBody
	@RequestMapping(value = "/lecList.do")
	public List<LectureVO> lecList(LectureVO lectureVO) {
		
		return studentService.selectLectureList(lectureVO);
	}
	//휴학신청페이지
	@RequestMapping(value = "/leaveOfAbsencePage.do")
	public String leaveOfAbsencePage(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		return "student/leaveOfAbsence";
	}
	//휴학신청(학생이 휴학신청 할 때)
	@RequestMapping(value = "/leaveOfAbsence.do")
	public String leaveOfAbsence(StatusRegVO statusRegVO) {
		studentService.changeStatus(statusRegVO);
		return "redirect:leaveOfAbsencePage.do?mainNum=2&sideNum=3&sideDetailNum=8";
	}
	//복학신청페이지
	@RequestMapping(value = "/returningToSchoolPage.do")
	public String returningToSchoolPage(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		return "student/returningToSchool";
	}
	
	//복학신청(학생이 복학신청 할 때)
	@RequestMapping(value = "/returningToSchool.do")
	public String returningToSchool(StatusRegVO statusRegVO) {
		studentService.changeStatus(statusRegVO);
		return "redirect:returningToSchoolPage.do?mainNum=2&sideNum=4&sideDetailNum=10";
	}
	//학적변동 신청 확인
	@ResponseBody
	@RequestMapping(value = "/checkComfirm.do")
	public StatusRegVO checkComfirm(int stuNum) {
		return studentService.checkComfirm(stuNum);
	}
	//자퇴신청페이지
	@RequestMapping(value = "/dropOutPage.do")
	public String dropOutPage(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
		return "student/dropOut";
	}
	//자퇴신청(학생이 자퇴신청 할 때)
	@RequestMapping(value = "/dropOut.do")
	public String dropOut(StatusRegVO statusRegVO) {
		studentService.changeStatus(statusRegVO);
		return "redirect:dropOutPage.do?mainNum=2&sideNum=5&sideDetailNum=12";
	}
	
	//예비수강신청 페이지
	@RequestMapping(value = "/enrolmentCartPage.do")
	public String enrolmentCartPage(Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO, LectureAInfoVO lectureAInfoVO) {
		model.addAttribute("depList", adminService.selectStuDep());
		model.addAttribute("collegeList", empService.selectColList());
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		int stuNum = vo.getMemId();
		
		//현재날짜
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
		Date time = new Date();
		String time1 = format1.format(time);
		int nowDate = Integer.parseInt(time1);
		//현재 날짜에 맞는 학기코드
		int semCode = studentService.selectSemester(nowDate);
		lectureAInfoVO.setSemCode(semCode);
		
		List<LectureAInfoVO> list1 = studentService.selectLecTTList(lectureAInfoVO);
		List<LecTimeVO> list2 = studentService.selectLecTimeList();
		List<StuTTCartVO> cartList = studentService.selectCartList(stuNum);
		
		for(int i = 0; i < list1.size(); i++) {
			List<LecTimeVO> list3 = new ArrayList<>();
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
					list3.add(list2.get(j));
				}
			}
			list1.get(i).setLecTimeList(list3);
		}
		
		for(int i = 0; i < cartList.size(); i++) {
			List<LecTimeVO> list3 = new ArrayList<>();
			for(int j = 0; j < list2.size(); j++) {
				if(cartList.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
					list3.add(list2.get(j));
				}
			}
			cartList.get(i).setLecTimeList(list3);
		}
		
		model.addAttribute("lecTTList", list1);
		model.addAttribute("cartList", cartList);
		return "student/enrolmentCart";
	}
	//예비수강신청페이지 -> 조건이 있는 강의목록 조회 & 과목 검색
	@ResponseBody
	@RequestMapping(value = "/selectLecTT.do")
	public List<LectureAInfoVO> selectLecTT(LecTTVO lecTTVO, LectureAInfoVO lectureAInfoVO, MenuSideDetailVO menuSideDetailVO) {
		//현재날짜
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
		Date time = new Date();
		String time1 = format1.format(time);
		int nowDate = Integer.parseInt(time1);
		//현재 날짜에 맞는 학기코드
		int semCode = studentService.selectSemester(nowDate);
		lectureAInfoVO.setSemCode(semCode);
		
		List<LectureAInfoVO> list1 = studentService.selectLecTTList(lectureAInfoVO);
		List<LecTimeVO> list2 = studentService.selectLecTimeList();
		
		System.out.println(list2);
		
		for(int i = 0; i < list1.size(); i++) {
			List<LecTimeVO> list3 = new ArrayList<>();
			
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					list3.add(list2.get(j));
				}
			}
			list1.get(i).setLecTimeList(list3);
		}
		return list1;
	}
	//예비수강신청 
	@RequestMapping(value = "/insertStuTTCart.do")
	public String insertStuTTCart(LecTTVO lecTTVO, StuTTCartVO stuTTCartVO, Model model) {
		//카트 담기
		studentService.insertTtCart(stuTTCartVO);
		//현재인원 증가
		studentService.updateAppNum(lecTTVO);
		model.addAttribute("mainNum", 3);
		model.addAttribute("sideNum", 8);
		model.addAttribute("sideDetailNum", 20);
		
		return "redirect:enrolmentCartPage.do";
	}
	//예비수강신청 취소
	@RequestMapping(value = "/deleteStuTTCart.do")
	public String deleteStuTTCart(LecTTVO lecTTVO, StuTTCartVO stuTTCartVO, Model model) {
		//카트에서 삭제
		studentService.deleteTtCart(stuTTCartVO);
		//현재인원 빼기
		studentService.minusAppNum(lecTTVO);
		
		model.addAttribute("mainNum", 3);
		model.addAttribute("sideNum", 8);
		model.addAttribute("sideDetailNum", 20);
		return "redirect:enrolmentCartPage.do";
	}
	
	//수강신청페이지 & 단과대학 리스트 (select box)
	@RequestMapping(value = "/enrolment.do")
	public String enrolment(Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		int stuNum = vo.getMemId();
		List<LecTimeVO> list2 = studentService.selectLecTimeList();
		
		List<StuTTCartVO> cartList = studentService.selectCartList(stuNum);
		for(int i = 0; i < cartList.size(); i++) {
			List<LecTimeVO> list3 = new ArrayList<>();
			for(int j = 0; j < list2.size(); j++) {
				if(cartList.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
					list3.add(list2.get(j));
				}
			}
			cartList.get(i).setLecTimeList(list3);
		}
		model.addAttribute("cartList", cartList);
		return "student/enrolment";
	}
	//수강신청
	@RequestMapping(value = "/insertStuTT.do")
	public String insertStuTT(HttpSession session, String[] lecTtCode, StuTTVO stuTTVO, StuTTCartVO stuTTCartVO, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		int stuNum = vo.getMemId();
		
		//과목바구니에서 담은 과목 수 만큼
		for (int i = 0; i < lecTtCode.length; i++) {
			// 수강신청
			stuTTVO.setStuNum(stuNum);
			stuTTVO.setLecTtCode(lecTtCode[i]);
			studentService.insertStuTT(stuTTVO);
			studentService.insertGrade(stuTTVO);
			// 장바구니 삭제
			stuTTCartVO.setStuNum(stuNum);
			stuTTCartVO.setLecTtCode(lecTtCode[i]);
			studentService.deleteTtCart(stuTTCartVO);
		}
		return "redirect:enrolment.do?mainNum=3&sideNum=9&sideDetailNum=22";
	}
	//수강취소 페이지
	@RequestMapping(value = "/delStuTTPage.do")
	public String delStuTTPage(HttpSession session, Model model, MenuSideDetailVO menuSideDetailVO) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		int stuNum = vo.getMemId();
		
		List<LecTimeVO> list2 = studentService.selectLecTimeList();
		List<StuTTVO> ttList = studentService.selectStuTTList(stuNum);
		
		for(int i = 0; i < ttList.size(); i++) {
			List<LecTimeVO> list3 = new ArrayList<>();
			for(int j = 0; j < list2.size(); j++) {
				if(ttList.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
					list3.add(list2.get(j));
				}
			}
			ttList.get(i).setLecTimeList(list3);
		}
		model.addAttribute("stuTTList", ttList);
		
		return "student/delStuTT";
	}
	//수강취소
	@RequestMapping(value = "/deleteStuTT.do")
	public String deleteStuTT(HttpSession session, StuTTVO stuTTVO, LecTTVO lecTTVO, Model model) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		int stuNum = vo.getMemId();
		
		stuTTVO.setStuNum(stuNum);
		lecTTVO.setLecTtCode(stuTTVO.getLecTtCode());
		
		studentService.deleteGrade(stuTTVO);
		studentService.deleteStuTT(stuTTVO);
		studentService.minusAppNum(lecTTVO);
		
		model.addAttribute("mainNum", 3);
		model.addAttribute("sideNum", 10);
		model.addAttribute("sideDetailNum", 23);
		
		return "redirect:delStuTTPage.do";
	}
	//시간표 조회
	@RequestMapping(value = "/stuTimetable.do")
	public String deleteStuTT(MenuSideDetailVO menuSideDetailVO, Model model) {
		model.addAttribute("ttSeq", empService.selectTimetable());
		
		return "student/stuTimetable";
	}
	//시간표 조회
	@RequestMapping(value = "/selectFacReserve.do")
	public String selectFacReserve(MenuSideDetailVO menuSideDetailVO, Model model, HttpSession session) {
		int memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		FacUseListVO fac = new FacUseListVO();
		fac.setMemId(memId);
		model.addAttribute("useList", empService.selectFacUseLista(fac));
		return "student/selectFacReserve";
	}


	//전과신청
	//전과신청페이지
	@RequestMapping(value = "/majorApplication.do")
	public String majorApplication(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {
					MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
					myInfoVO.setStuNum(vo.getMemId());
					applyManagementVO.setStuNum(vo.getMemId());			
					model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));			
					model.addAttribute("collegeList", adminService.selectCollegeList());
					model.addAttribute("depList", adminService.selectStuDep());				
					model.addAttribute("mainNum", 2);
					model.addAttribute("sideNum", 6);
					model.addAttribute("sideDetailNum", 14);			
			return "student/majorApplication";
		}	
		//전과신청
		@RequestMapping(value = "/insertMajor.do")
		public String insertMajor(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {	
			MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
			myInfoVO.setStuNum(vo.getMemId());
			applyManagementVO.setApplyType(1);
			studentService.insertApplyManagement(applyManagementVO);
			model.addAttribute("mainNum", 2);
			model.addAttribute("sideNum", 6);
			model.addAttribute("sideDetailNum", 14);	
			return "redirect:majorApplication.do";
		}

		//전과신청 리스트
		@ResponseBody
		@RequestMapping(value = "/majorApplicationList.do")
			public List<ApplyManagementVO>  majorApplicationList(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {	
				return studentService.selectDoubleMajorList(applyManagementVO);
		}		
		//전과신청취소
		@ResponseBody
		@RequestMapping(value = "/deleteMajorList.do")
		public int  deleteMajorList(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {		
			model.addAttribute("mainNum", 2);
			model.addAttribute("sideNum", 6);
			model.addAttribute("sideDetailNum", 14);
			return studentService.deleteMajorList(applyManagementVO);
		}
		//복수전공신청페이지
		@RequestMapping(value = "/doubleMajorApplication.do")
		public String doubleMajorApplication(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {
				MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
				myInfoVO.setStuNum(vo.getMemId());			
			
				model.addAttribute("collegeList", adminService.selectCollegeList());
				model.addAttribute("depList", adminService.selectStuDep());
				model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
				
				return "student/doubleMajorApplication";
		}	
		//복수전공 신청
		@RequestMapping(value = "/insertDoubleMajor.do")
		public String insertDoubleMajor(MyInfoVO myInfoVO, Model model, HttpSession session, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {	
			MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
			myInfoVO.setStuNum(vo.getMemId());
		
			applyManagementVO.setApplyType(2);
			studentService.insertApplyManagement(applyManagementVO);
				
			model.addAttribute("mainNum", 2);
			model.addAttribute("sideNum", 6);
			model.addAttribute("sideDetailNum", 16);
			return "redirect:doubleMajorApplication.do";
		}		
		
		//복수전공 신청확인
			@ResponseBody
			@RequestMapping(value = "/majorAplicationConfirm.do")
			public int  majorAplicationConfirm(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {	
				return studentService.majorAplicationConfirm(applyManagementVO);
		}
		
		//복수전공신청 리스트
		@ResponseBody
		@RequestMapping(value = "/doubleMajorApplicationList.do")
			public List<ApplyManagementVO>  doubleMajorApplicationList(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {	
				return studentService.selectDoubleMajorList(applyManagementVO);
		}		
		//복수전공신청취소
		@ResponseBody
		@RequestMapping(value = "/deleteDoubleMajorList.do")
		public int  deleteDoubleMajorList(MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO) {		
			model.addAttribute("mainNum", 2);
			model.addAttribute("sideNum", 6);
			model.addAttribute("sideDetailNum", 16);
			return studentService.deleteDoubleMajorList(applyManagementVO);
		}
			
		//내 시간표 조회
		@ResponseBody
		@RequestMapping(value = "/selectMyTimetable.do")
		public List<MyTimetableVO> selectMyTimetable(MyTimetableVO myTimetableVO) {	
			
			List<MyTimetableVO> list1 = studentService.selectMytimetable(myTimetableVO);
			List<LecTimeVO> list2 = studentService.selectLecTimeList();
			
			for(int i = 0; i < list1.size(); i++) {
				List<LecTimeVO> list3 = new ArrayList<>();
				
				for(int j = 0; j < list2.size(); j++) {
					if(list1.get(i).getLecTtCode().equals(list2.get(j).getLecTtCode())) {
						list3.add(list2.get(j));
					}
				}
				list1.get(i).setLecTimeList(list3);
			}
			
			return list1;
		}
		@ResponseBody
		@RequestMapping(value = "/selectfacUseListA.do")
		public List<FacUseListVO> selectfacUseListA(FacUseListVO facUseListVO , String facCodeArr, HttpSession session) {
			
			if(!facCodeArr.equals("")) {
				String[] aa = facCodeArr.split(",");
				List<String> list = Arrays.asList(aa);
				facUseListVO.setFacCodeList(list);
			}
			int memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
			facUseListVO.setMemId(memId);
			
		
			return empService.selectFacUseLista(facUseListVO);
		}
		
		//성적조회
		@RequestMapping(value = "/grade.do")
		public String Grade(HttpSession session, MenuSideDetailVO menuSideDetalVO, Model model, MemberVO memberVO) {
			memberVO = (MemberVO)session.getAttribute("loginInfo");
			List<SemGradeVO> one = studentService.selectSemGrade(memberVO);
			List<SemGradeVO> two = studentService.selectSemLecCredit(memberVO);
			
			for(SemGradeVO e: one) {
				for(SemGradeVO a: two) {
					if(e.getSemCode() == a.getSemCode()) {
						e.setAcqiredCredit(a.getAcqiredCredit());
					}
				}
			}
			
			model.addAttribute("semGradeList", one);
			model.addAttribute("totalGrade", studentService.selectTotalGrade(memberVO));
			
			return "student/stuGrade";
		}	
		
	    
	    //성적 디테일 조회
	    @ResponseBody
	    @RequestMapping(value = "/selectGradeDetail.do")
	    public List<SemGradeDetailVO> selectGradeDetail(HttpSession session, Model model, SemGradeDetailVO semGradeDetailVO) {
	    	semGradeDetailVO.setStuNum(((MemberVO)session.getAttribute("loginInfo")).getMemId());
	    	return studentService.selectGradeDetail(semGradeDetailVO);
	    }
	
		//학생 졸업
		@RequestMapping(value = "/graduated.do")
		public String  graduated(HttpSession session, MyInfoVO myInfoVO, Model model, MenuSideDetailVO menuSideDetailVO,ApplyManagementVO applyManagementVO,MyGradeVO myGradeVO) {		
			MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
			myInfoVO.setStuNum(vo.getMemId());
			model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
			myGradeVO.setStuNum(vo.getMemId());
			model.addAttribute("grade", studentService.selectMyGrade(myGradeVO));
			List<MyGradeVO> list1 = studentService.groupMyGrade(myGradeVO);
			model.addAttribute("grade1", list1);
			model.addAttribute("grade2", studentService.AllMyInfo(myGradeVO));
			System.out.println(list1);
			
			return "student/graduated";
		}
		
}
