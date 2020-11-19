package com.spring.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.AdminService;
import com.spring.biz.EmpService;
import com.spring.biz.MemberService;
import com.spring.biz.StudentService;
import com.spring.biz.vo.ApplyManagementVO;
import com.spring.biz.vo.DepVO;
import com.spring.biz.vo.EmpVO;
import com.spring.biz.vo.ExpelVO;
import com.spring.biz.vo.FacUseListVO;
import com.spring.biz.vo.FacilityVO;
import com.spring.biz.vo.LecTTVO;
import com.spring.biz.vo.LecTimeVO;
import com.spring.biz.vo.LectureVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MyInfoVO;
import com.spring.biz.vo.ProbationVO;
import com.spring.biz.vo.RepairRequestVO;
import com.spring.biz.vo.StudentVO;
import com.spring.biz.vo.TimetableVO;
import com.spring.email.Email;
import com.spring.email.EmailSender;
import com.spring.email.ExpelMailForm;
import com.spring.email.ProbationMailForm;
import com.spring.email.CancelFacUseMailForm;

@Controller
public class EmpController {
	@Resource(name = "empService")
	EmpService empService;
	@Resource(name = "memberService")
	MemberService memberService;
	@Resource(name = "adminService")
	AdminService adminService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Autowired 
	ServletContext servletContext;
	
	@Autowired
	   private JavaMailSender mailSender;
	
	
	
	//시설 예약 페이지로 이동
	@RequestMapping(value = "/facReserve.do")
	public String facReserve(MenuSideDetailVO menuSideDetailVO, HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		model.addAttribute("memName", memberService.selectMemName(loginInfo));
		
		return "emp/facReserve";
	}
	//강의 등록 페이지로 이동
	@RequestMapping(value = "/insertLecture.do")
	public String insertLecture(Model model, MenuSideDetailVO menuSideDetailVO) {
		model.addAttribute("colList", empService.selectColList());
		return "emp/insertLecture";
	}
	
	//강의 등록 쿼리 실행
	@RequestMapping(value = "/insertLec.do")
	public String insertLec(LectureVO lectureVO, Model model, MenuSideDetailVO menuSideDetailVO, MultipartHttpServletRequest multi) throws IOException {
		model.addAttribute("colList", empService.selectColList());
		
		
		//첨부파일에 대한 encoding 설정
		multi.setCharacterEncoding("UTF-8");		
		//multipartRequest에서 첨부파일에 대한 데이터를 받아온다
		MultipartFile mf = multi.getFile("lecFile");
		String originFileName = mf.getOriginalFilename();
		
		//실제 파일명을 현재날짜_원본파일 형태의 이름으로 지정
		String realName = originFileName;
		
		File file = new File("D:\\uploadFile\\uniPotal\\");
			
				//첨부파일의 용량이 0이 아니면
				if(mf.getSize() != 0) {
					
					if(!file.exists()) {
						System.out.println("!!!!!!!");
						file.mkdirs();
					}
					//해당하는 경로에 첨부파일을 업로드한다
					mf.transferTo(new File("D:\\uploadFile\\uniPotal\\" + realName));
				}
				
		lectureVO.setAttachment(realName);
		model.addAttribute("insertResult", empService.insertLec(lectureVO));
		return "emp/insertLecture";
	}

	
	@RequestMapping(value = "/updateLecPage.do")
	public String manageLecture(Model model,MenuSideDetailVO menuSideDetailVO,   LectureVO lectureVO) {
		model.addAttribute("lectureList", empService.selectLectureList(lectureVO));
		return "emp/updateLecture";
	}
	
	@RequestMapping(value = "/updateLec.do")
	public String updateLec(Model model,MenuSideDetailVO menuSideDetailVO,  LectureVO lectureVO) {
		model.addAttribute("colList", empService.selectColList());
		model.addAttribute("lectureInfo", empService.selectLecture(lectureVO));
		model.addAttribute("side", menuSideDetailVO);
		return "emp/updateLecPage";
	}
	
	@RequestMapping(value = "/updateLectureInfo.do")
	public String updateLectureInfo(Model model,MenuSideDetailVO menuSideDetailVO, LectureVO lectureVO) {
		LectureVO vo = new LectureVO();
		model.addAttribute("updateResult", empService.updateLectureInfo(lectureVO));
		model.addAttribute("lectureList", empService.selectLectureList(vo));
		
		return "emp/updateLecture";
	}
	
	@RequestMapping(value = "/deleteLecPage.do")
	public String deleteLecPage(Model model, MenuSideDetailVO menuSideDetailVO, LectureVO lectureVO) {
		model.addAttribute("lectureList", empService.selectLectureList(lectureVO));
		return "emp/deleteLecture";
	}
	
	@RequestMapping(value = "/openLecPage.do")
	public String openLecPage(Model model, LectureVO lectureVO, HttpSession session, MenuSideDetailVO menuSideDetailVO) {
		MemberVO loginMember = (MemberVO)session.getAttribute("loginInfo");
		model.addAttribute("lectureList", empService.selectLectureList(lectureVO));
		model.addAttribute("colList", empService.selectColList());
		return "emp/openLecture";
	}
	
	@RequestMapping(value = "/openLec2.do")
	public String openLec2(Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO) {
		model.addAttribute("lecture", empService.selectLecture(lectureVO));
		return "emp/openLec2";
	}
	
	//시설예약
	@RequestMapping(value = "/insertFacUse.do")
	public String insertFacUse(FacUseListVO facUseListVO, HttpSession session,Model model ,MenuSideDetailVO menuSideDetailVO) {
		facUseListVO.setMemId(((MemberVO)session.getAttribute("loginInfo")).getMemId());
		
		
		model.addAttribute("insertResult", empService.insertFacUse(facUseListVO));
		return "emp/facReserve";
	}
	
	//강의 개설
	@RequestMapping(value = "/openLecture.do")
	public String openLecture(MenuSideDetailVO menuSideVO, Model model,LecTTVO lecTTVO, Integer[] lecWeekArr, Integer[] ttSeqArr, String[] facCodeArr) {
		
		List<LecTimeVO> list = new ArrayList<>();
		String lecTtCode = lecTTVO.getSemCode() + lecTTVO.getLecCode();
		lecTTVO.setLecTtCode(lecTtCode);
		
		for(int i = 0; i< lecWeekArr.length; i++) {
			LecTimeVO lectimeVO = new LecTimeVO();
			
			lectimeVO.setLecWeek(lecWeekArr[i]);
			lectimeVO.setTtSeq(ttSeqArr[i]);
			lectimeVO.setFacCode(facCodeArr[i]);
			lectimeVO.setLecTtCode(lecTtCode);
			
			list.add(lectimeVO);
		}
		
		for(LecTimeVO e : list) {
			System.out.println(e);
		}
		
		model.addAttribute("openLecResult", empService.openLecture(lecTTVO, list));
		
		
		return "emp/openLecResult";
	}
	
	
	//시설사용목록 페이지로 이동
	@RequestMapping(value = "/facUseList.do")
	public String facUseList(FacUseListVO facUseListVO, MenuSideDetailVO menuSideDetailVO, Model model) {
		model.addAttribute("useList", empService.selectFacUseLista(facUseListVO));
		return "emp/facUseList";
	}
	
	//시설사용취소 페이지로 이동
	@RequestMapping(value = "/cancelFacUse.do")
	public String cancelFacUse(FacUseListVO facUseListVO, MenuSideDetailVO menuSideDetailVO, Model model) {
		model.addAttribute("useList", empService.selectFacUseLista(facUseListVO));
		return "emp/cancelFacUse";
	}
	
	
	//학사경고 페이지로 이동
	@RequestMapping(value = "/probationPage.do")
	public String probationPage(MenuSideDetailVO menuSideDetailVO, Model model,  MyInfoVO myInfoVO) {
		
		model.addAttribute("studentList", adminService.selectStudentList(myInfoVO));
		model.addAttribute("collegeList", adminService.selectCollegeList());
		model.addAttribute("depList", adminService.selectStuDep());
		model.addAttribute("statusList", adminService.selectStatusList());
		
		return "emp/probationPage";
	}
	
	//제적 페이지로 이동
	@RequestMapping(value = "/expelPage.do")
	public String expelPage(MenuSideDetailVO menuSideDetailVO, Model model,  MyInfoVO myInfoVO) {
		
		model.addAttribute("studentList", adminService.selectStudentList(myInfoVO));
		model.addAttribute("collegeList", adminService.selectCollegeList());
		model.addAttribute("depList", adminService.selectStuDep());
		model.addAttribute("statusList", adminService.selectStatusList());
		
		return "emp/expelPage";
	}
	
	
	
	
//	//단대별 학과 조회
//		if(! facUseListVO.getUserEmail().equals("") || facUseListVO.getUserEmail() == null) {
//			String subject = "[KH대학교] "
//					+ facUseListVO.getFacUseDay() + "시설 예약 철회 안내";
//			System.out.println(facUseListVO + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//			MemberVO memberVO = new MemberVO();
//			memberVO.setMemId(facUseListVO.getMemId());
//			memberVO.setMemGrade(memberService.selectMemberGrade(memberVO));
//	
//			String memberName = memberService.selectMemName(memberVO);
//			System.out.println(memberName);
////			String content = memberName + "(" + memberVO.getMemId() + ") 님  \n\n"; 
////			content += "다음과같은 이유로 이유로 아래의 시설 사용이 취소되었음을 알려드립니다.\n\n";
////			content += "신청번호 : " + facUseListVO.getFacUseNum() +"\n";
////			content += "신청자 : " + memberName + "(" + memberVO.getMemId() + ")\n" ;
////			content += "신청시설 : " + facUseListVO.getFacName() +"\n";
////			content += "사용일시 : " + facUseListVO.getFacUseDay() + "\n";
////			content += "취소 사유 : " + cancelReason;
//			
//			cancelFacUseMailForm form = new cancelFacUseMailForm(1);
//			
//			String content = form.getText();
//			
//			email.setReceiver(facUseListVO.getUserEmail());
//			email.setContent(content);
//			email.setSubject(subject);
//            try {
//				emailSender.SendEmail(email);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//		}
//		
//	}
		@ResponseBody
	   @RequestMapping(value = "/deleteFacUse.do")
	   public int mailSending(HttpServletRequest request, FacUseListVO facUseListVO, String cancelReason) {
			if(! facUseListVO.getUserEmail().equals("") || facUseListVO.getUserEmail() == null) {
				String subject = "[KH대학교] 시설 예약 철회 안내";
				
				 MemberVO memberVO = new MemberVO();
		         memberVO.setMemId(facUseListVO.getMemId());
		         memberVO.setMemGrade(memberService.selectMemberGrade(memberVO));
		         memberVO.setMemName(memberService.selectMemName(memberVO));
		         
		         facUseListVO.setCacelReason(cancelReason);
		        
		         
			      try {
			    	  CancelFacUseMailForm cf = new CancelFacUseMailForm(memberVO, facUseListVO);
			    	  String contents = cf.getText(); 
			    	  
			    	  
			         MimeMessage message = mailSender.createMimeMessage();
			         MimeMessageHelper messageHelper = getMessageHelper(message, subject, contents ,facUseListVO.getUserEmail());
			         
			         System.out.println(facUseListVO.getUserEmail()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
			         mailSender.send(message);
			      } catch (Exception e) {
			         System.out.println(e);
			      }
			}
			
		return empService.deleteFacUse(facUseListVO);
	   }
	
	   public MimeMessageHelper getMessageHelper(MimeMessage message, String subject, String content, String userEmail) {
		   try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			 messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
	         messageHelper.setFrom("unipotal2020@gmail.com"); // 보내는사람 생략하면 정상작동을 안함
	         messageHelper.setTo(userEmail); // 받는사람 이메일
	         messageHelper.setText(content, true); 
	         
	         
	         FileSystemResource file1 = new FileSystemResource(new File("D:\\workspaceSpring\\ProjectBase\\src\\main\\webapp\\resources\\images\\image-1.png")); 
	         messageHelper.addInline("image-1.png", file1);
	         FileSystemResource file2 = new FileSystemResource(new File("D:\\workspaceSpring\\ProjectBase\\src\\main\\webapp\\resources\\images\\image-2.png")); 
	         messageHelper.addInline("image-2.png", file2);
	         FileSystemResource file3 = new FileSystemResource(new File("D:\\workspaceSpring\\ProjectBase\\src\\main\\webapp\\resources\\images\\image-3.png")); 
	         messageHelper.addInline("image-3.png", file3);
	         FileSystemResource file4 = new FileSystemResource(new File("D:\\workspaceSpring\\ProjectBase\\src\\main\\webapp\\resources\\images\\image-4.png")); 
	         messageHelper.addInline("image-4.png", file4);
	         FileSystemResource file5 = new FileSystemResource(new File("D:\\workspaceSpring\\ProjectBase\\src\\main\\webapp\\resources\\images\\image-5.png")); 
	         messageHelper.addInline("image-5.png", file5);
	         return  messageHelper;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		   return null;
	   }
	
	
	//단대별 학과 조회
	@ResponseBody
	@RequestMapping(value = "/selectDepList.do")
	public List<DepVO> selectDepList(DepVO depVO) {
		return empService.selectDepList(depVO);
	}
	
	//임직원조회
	@ResponseBody
	@RequestMapping(value = "/selectEmpList.do")
	public List<EmpVO> selectEmpList(EmpVO empVO) {
		return empService.selectEmpList(empVO);
	}
	
	//임직원조회
	@ResponseBody
	@RequestMapping(value = "/deleteLec.do")
	public int deleteLec(LectureVO lectureVO) {
		return empService.deleteLec(lectureVO);
	}
	//임직원조회
	@ResponseBody
	@RequestMapping(value = "/selectLecList.do")
	public List<LectureVO> selectLecList(LectureVO lectureVO) {
		return empService.selectLectureList(lectureVO);
	}
	//시간표 정보 조회
	@ResponseBody
	@RequestMapping(value = "/selectTimetable.do")
	public List<TimetableVO> selectTimetable() {
		return empService.selectTimetable();
	}
	//FacLoc 조회
	@ResponseBody
	@RequestMapping(value = "/selectFacLoc.do")
	public List<FacilityVO> selectFacLoc() {
		return empService.selectFacLoc();
	}
	//FacLocDetail 조회
	@ResponseBody
	@RequestMapping(value = "/selectFacDetail.do")
	public List<FacilityVO> selectFacDetail(FacilityVO facilityVO) {
		return empService.selectFacDetail(facilityVO);
	}
	//시설 사용 가능 목록 조회
	@ResponseBody
	@RequestMapping(value = "/selectFacCondition.do")
	public List<TimetableVO> selectFacCondition(FacUseListVO facUseListVO) {
		List<TimetableVO> list1 = empService.selectTimetable();
		List<FacUseListVO> list2 = empService.selectFacUseList(facUseListVO);
		
		for(int i = 0; i < list1.size(); i++) {
			list1.get(i).setIsReserved("N");
			for(int j = 0 ; j < list2.size(); j++) {
				if(list1.get(i).getTtSeq() == list2.get(j).getTtSeq()) {
					list1.get(i).setIsReserved("Y");
				}
			}
		}
		System.out.println(list1);
		
		return list1;
	}
	//FacLocDetail 조회
	@ResponseBody
	@RequestMapping(value = "/selectFacListA.do")
	public List<FacUseListVO> selectFacListA(FacUseListVO facUseListVO , String facCodeArr) {
		
		if(!facCodeArr.equals("")) {
			String[] aa = facCodeArr.split(",");
			List<String> list = Arrays.asList(aa);
			facUseListVO.setFacCodeList(list);
		}
	
		return empService.selectFacUseLista(facUseListVO);
	}
	
	//제적 시키기
	@ResponseBody
	@RequestMapping(value = "/insertExpel.do")
	public int insertExpel(ExpelVO expelVO) {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
		Date time = new Date();
		String time1 = format.format(time);
		
		expelVO.setExpelDate(time1);
		
		if(! expelVO.getUserEmail().equals("") || expelVO.getUserEmail() == null) {
			
			
			String subject = "[KH대학교] 제적처리 알림";
			MemberVO memberVO = new MemberVO();
			 memberVO.setMemId(expelVO.getStuNum());
	         memberVO.setMemGrade(memberService.selectMemberGrade(memberVO));
	         memberVO.setMemName(memberService.selectMemName(memberVO));
	         
	        
	         
		      try {
		    	  System.out.println(expelVO.getExpelReason() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		    	  ExpelMailForm pf = new ExpelMailForm(memberVO, expelVO);
		    	  String contents = pf.getText(); 
		    	  
		    	  
		         MimeMessage message = mailSender.createMimeMessage();
		         MimeMessageHelper messageHelper = getMessageHelper(message, subject, contents ,expelVO.getUserEmail());
	
	
		         mailSender.send(message);
		      } catch (Exception e) {
		         System.out.println(e);
		      }
		}
		
		empService.updateStudentExpel(expelVO.getStuNum());

				
		
		return empService.insertExpel(expelVO);
	}
	
	//학사경고실행
	@ResponseBody
	@RequestMapping(value = "/insertProbation.do")
	public int insertProbation(ProbationVO probationVO) {
		if(! probationVO.getUserEmail().equals("") || probationVO.getUserEmail() == null) {
			String subject = "[KH대학교] 학사경고 알림";
			MemberVO memberVO = new MemberVO();
			memberVO.setMemId(probationVO.getStuNum());
			memberVO.setMemGrade(memberService.selectMemberGrade(memberVO));
			memberVO.setMemName(memberService.selectMemName(memberVO));
			
			
			
			try {
				ProbationMailForm pf = new ProbationMailForm(memberVO, probationVO);
				String contents = pf.getText(); 
				
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = getMessageHelper(message, subject, contents ,probationVO.getUserEmail());
				
				
				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		
		return empService.insertProbation(probationVO);
	}
	//전과/부전공 신청관리 페이지
	@RequestMapping(value = "/applyManagement.do")
	public String applyManagement(HttpSession session, Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO) {
			model.addAttribute("majorList",  empService.selectMajorList());		
		return "emp/applyManagement";
	}
	
	//신청 학생 정보
	@ResponseBody
	@RequestMapping(value = "/selectStudentInfo.do")
	public List<MyInfoVO> selectStudentInfo(HttpSession session, Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO) {
		return memberService.majorStudentInfo(myInfoVO);
	}
	
	//전과/부전공 신청관리 승인
    @ResponseBody
	@RequestMapping(value = "/updateApplyStudent.do")
	public int updateApplyStudent(HttpSession session, Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO, ApplyManagementVO applyManagementVO) {
		return empService.updateApplyStudent(applyManagementVO);
	}
    //전과/ 신청관리 승인 업데이트
    @ResponseBody
	@RequestMapping(value = "/updateMajorStudent.do")
	public int updateMajorStudent(HttpSession session, Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO, StudentVO studentVO) {
		return studentService.updateMajorStudent(studentVO);
    }
	//부전공 신청관리 승인 업데이트
    @ResponseBody
	@RequestMapping(value = "/updateDoubleMajorStudent.do")
	public int updateDoubleMajorStudent(HttpSession session, Model model, LectureVO lectureVO, MenuSideDetailVO menuSideDetailVO, MyInfoVO myInfoVO, StudentVO studentVO) {
		return studentService.updateDoubleMajorStudent(studentVO);
	}
    

    
  //대학생활 -고장 수리 신청목록
  	@RequestMapping(value = "/repairRequest2.do")
  	public String repairRequest2(MenuSideDetailVO menuSideDetailVO,Model model, RepairRequestVO repairRequestVO, @RequestParam(required = false, defaultValue = "1") int page
  			, @RequestParam(required = false, defaultValue = "1") int range) {
  		
  		int listCnt = studentService.getRepairListCnt(repairRequestVO);
  		repairRequestVO.pageInfo(page, range, listCnt);
  		
  		List<RepairRequestVO> list = studentService.selectRepairRequest(repairRequestVO);
  		
  		model.addAttribute("repairList", list);
  		model.addAttribute("side", menuSideDetailVO);
  		
  		return "emp/repairRequest2";
  	}

	//대학생활 -고장 수리신청 페이지
	@RequestMapping(value = "/repairRequestForm2.do")
	public String repairRequestForm2(MenuSideDetailVO menuSideDetailVO, HttpSession session, MyInfoVO myInfoVO,Model model,RepairRequestVO repairRequestVO) {
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		myInfoVO.setStuNum(vo.getMemId());
		
		model.addAttribute("myInfo", memberService.studentMyInfo(myInfoVO));
			
		return "emp/repairRequestForm2";
	}
	
		//관리자-고장 승인 
			@ResponseBody
			@RequestMapping(value = "/updateRepiarRequest.do")
			public int updateRepiarRequest(MenuSideDetailVO menuSideDetailVO, HttpSession session, MyInfoVO myInfoVO,Model model,RepairRequestVO repairRequestVO) {
					
				return studentService.updateRepiarRequest(repairRequestVO);
			}	
}










