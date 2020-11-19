package com.spring.view;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.biz.CommonService;
import com.spring.biz.MemberService;
import com.spring.biz.vo.BoardCategoryListVO;
import com.spring.biz.vo.BoardCommentVO;
import com.spring.biz.vo.BoardVO;
import com.spring.biz.vo.CalendarVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.MenuSideDetailVO;

@Controller
public class CommonController {
	@Resource(name = "commonService")
	CommonService commonService;
	@Resource(name = "memberService")
	MemberService memberService;
	
		//게시판 리스트 + 카테고리 명 + 카테고리 번호 가지고가기
		@RequestMapping(value = "/board.do")
		public String board(HttpSession session ,MemberVO memberVO ,MenuSideDetailVO menuSideDetailVO ,Model model, BoardVO boardVO, @RequestParam(required = false, defaultValue = "1") int page
				, @RequestParam(required = false, defaultValue = "1") int range) 
		
		{
			MemberVO vo1 = (MemberVO)session.getAttribute("loginInfo");
			
			model.addAttribute("memGrade", vo1.getMemGrade());
			//게시판 이름
			BoardCategoryListVO vo = commonService.categoryName(boardVO.getCategoryNum());
			model.addAttribute("categoryName", vo);
			
			if(menuSideDetailVO.getMainNum() == 4 && menuSideDetailVO.getSideDetailNum() == 0 && menuSideDetailVO.getSideNum() == 0) {
				boardVO.setCategoryNum(3);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			
			if(menuSideDetailVO.getSideNum() == 31 && menuSideDetailVO.getSideDetailNum() == 0) {
				boardVO.setCategoryNum(4);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			
			if(menuSideDetailVO.getSideNum() == 12 && menuSideDetailVO.getSideDetailNum() == 0) {
				boardVO.setCategoryNum(1);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			
			if(menuSideDetailVO.getSideNum() == 11 && menuSideDetailVO.getSideDetailNum() == 0) {
				boardVO.setCategoryNum(3);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			
			// CATEGORY_NUM 값 넣어주기
			if(menuSideDetailVO.getSideDetailNum() == 26) {
				boardVO.setCategoryNum(1);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			if(menuSideDetailVO.getSideDetailNum() == 27) {
				boardVO.setCategoryNum(2);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			if(menuSideDetailVO.getSideDetailNum() == 24) {
				boardVO.setCategoryNum(3);
				model.addAttribute("category", boardVO.getCategoryNum());
			}
			
			//전체 게시글 개수
			int listCnt = commonService.getBoardListCnt(boardVO);
			
			//페이징 변수넣기
			boardVO.pageInfo(page, range, listCnt);
			
			//게시판 불러오기
			List<BoardVO> list = commonService.boardList(boardVO);
			model.addAttribute("board", list);
			model.addAttribute("side", menuSideDetailVO);
			
			return "common/board"; 
		}
		
		// 글쓰기 폼 화면
		@RequestMapping(value = "/writeForm.do")
		public String writeForm(HttpSession session ,MemberVO memberVO ,MenuSideDetailVO menuSideDetailVO, Model model, int categoryNum) {
			model.addAttribute("category", categoryNum);
			model.addAttribute("side", menuSideDetailVO);
			MemberVO vo1 = (MemberVO)session.getAttribute("loginInfo");
			model.addAttribute("memName", memberService.selectMemName(vo1));
			
			return "common/writeForm"; 
		}
		
		//실제 글쓰기 구현
		@RequestMapping(value = "/write.do")
		public String write(MenuSideDetailVO menuSideDetailVO, Model model, BoardVO boardVO, RedirectAttributes re) {
			
			commonService.insertBoard(boardVO);
			
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			re.addAttribute("categoryNum" ,boardVO.getCategoryNum());
			
			return "redirect:board.do";
		}
		
		// 상세보기
		@RequestMapping(value = "/boardDetail.do")
		public String boardDetail(HttpSession session ,MemberVO memberVO ,MenuSideDetailVO menuSideDetailVO, Model model, int categoryNum, BoardVO boardVO, int boardNum) {
			
			BoardVO vo = commonService.detail(boardVO);
			model.addAttribute("category", categoryNum);
			model.addAttribute("detail", vo);
			commonService.readCnt(vo.getBoardNum());
			List<BoardCommentVO> list = commonService.selectComment(boardNum);
			model.addAttribute("commentList", list);
			model.addAttribute("side", menuSideDetailVO);
			MemberVO vo1 = (MemberVO)session.getAttribute("loginInfo");
			model.addAttribute("memName", memberService.selectMemName(vo1));
			model.addAttribute("memGrade", vo1.getMemGrade());
			
			return "common/boardDetail"; 
		}
		
		// 글삭제
		@RequestMapping(value = "/delete.do")
		public String delete(MenuSideDetailVO menuSideDetailVO, BoardVO boardVO, RedirectAttributes re) {
			
			commonService.deleteBoard(boardVO);
			re.addAttribute("categoryNum", boardVO.getCategoryNum());
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			
			return "redirect:board.do";
		}
		
		// 댓글삭제
		@RequestMapping(value = "/deleteComment.do")
		public String deleteComment(MenuSideDetailVO menuSideDetailVO, BoardVO boardVO, RedirectAttributes re, int commentNum) {
			System.out.println("!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@");
			commonService.deleteComment(commentNum);
			re.addAttribute("categoryNum", boardVO.getCategoryNum());
			re.addAttribute("boardNum", boardVO.getBoardNum());
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			commonService.commentCnt1(boardVO.getBoardNum());
			
			return "redirect:boardDetail.do";
		}
		
		// 수정화면
		@RequestMapping(value = "/updateForm.do")
		public String updateForm(HttpSession session ,MemberVO memberVO ,MenuSideDetailVO menuSideDetailVO, Model model, BoardVO boardVO) {
			
			BoardVO vo = commonService.detail(boardVO);
			model.addAttribute("boardNum", boardVO.getBoardNum());
			model.addAttribute("categoryNum", boardVO.getCategoryNum());
			model.addAttribute("update", vo);
			model.addAttribute("side", menuSideDetailVO);
			MemberVO vo1 = (MemberVO)session.getAttribute("loginInfo");
			model.addAttribute("memName", memberService.selectMemName(vo1));
			
			return "common/updateForm";
		}
		
		// 수정화면
		@ResponseBody
		@RequestMapping(value = "/commentUpdate.do")
		public int commentUpdate(BoardCommentVO boardCommentVO) {
			
			return commonService.updateComment(boardCommentVO);
		}
		
		// 수정완료
		@RequestMapping(value = "/update.do")
		public String update(MenuSideDetailVO menuSideDetailVO, BoardVO boardVO, RedirectAttributes re) {
			
			commonService.updateBoard(boardVO);
			re.addAttribute("categoryNum", boardVO.getCategoryNum());
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			
			return "redirect:board.do";
		}
		
		// 댓글작성
		@RequestMapping(value = "/insertComment.do")
		public String insertComment(MenuSideDetailVO menuSideDetailVO, Model model, BoardCommentVO boardCommentVO, BoardVO boardVO, RedirectAttributes re) {
			
			commonService.insertComment(boardCommentVO);
			re.addAttribute("categoryNum", boardVO.getCategoryNum());
			re.addAttribute("boardNum", boardVO.getBoardNum());
			commonService.commentCnt(boardVO.getBoardNum());
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			
			return "redirect:boardDetail.do";
		}
		
		// 답글작성
		@RequestMapping(value = "/replyForm.do")
		public String replyForm(HttpSession session ,MemberVO memberVO ,MenuSideDetailVO menuSideDetailVO, BoardVO boardVO, Model model) {

			model.addAttribute("categoryNum", boardVO.getCategoryNum());
			model.addAttribute("boardNum", boardVO.getBoardNum());
			model.addAttribute("side", menuSideDetailVO);
			MemberVO vo1 = (MemberVO)session.getAttribute("loginInfo");
			model.addAttribute("memName", memberService.selectMemName(vo1));
			
			return "common/reply";
		}
		
		// 답글작성완료
		@RequestMapping(value = "/reply.do")
		public String reply(MenuSideDetailVO menuSideDetailVO, BoardVO boardVO, Model model, RedirectAttributes re) {
			
			commonService.insertBoard1(boardVO);
			re.addAttribute("categoryNum", boardVO.getCategoryNum());
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			
			return "redirect:board.do";
		}
	
		//캘린더 데이터 조회
		@ResponseBody
		@RequestMapping(value = "/sampleAjax.do")
		public List<CalendarVO> sample(Model model, CalendarVO calendarVO) {
			List<CalendarVO> list = commonService.selectCalendar();
			model.addAttribute("list", list);
			
			return list; 
		}
		
		//student calendar
		@RequestMapping(value = "/stuCal.do")
		public String stuCal(Model model, MenuSideDetailVO menuSideDetailVO, CalendarVO calendarVO) {
			List<CalendarVO> list = commonService.selectCalendar();
			System.out.println(calendarVO.getCalStartDate());
			System.out.println("!@!@!@!@!@");
			List<CalendarVO> list1 = commonService.selectCalendar1(calendarVO);
			model.addAttribute("list", list);
			model.addAttribute("list1", list1);
			model.addAttribute("side", menuSideDetailVO);
			
			return "common/stuCal";
		}
		
		//Admin calendar
		@RequestMapping(value = "/adminCal.do")
		public String adminCal(Model model, MenuSideDetailVO menuSideDetailVO, CalendarVO calendarVO) {
			List<CalendarVO> list = commonService.selectCalendar();
		
			List<CalendarVO> list1 = commonService.selectCalendar1(calendarVO);
			model.addAttribute("list", list);
			model.addAttribute("list1", list1);
			model.addAttribute("side", menuSideDetailVO);
			
			return "common/adminCal";
		}
		
		//캘린더 데이터 조회
		@ResponseBody
		@RequestMapping(value = "/adminAjax.do")
		public List<CalendarVO> adminAjax(HttpSession session ,MemberVO memberVO , Model model, CalendarVO calendarVO) {
			List<CalendarVO> list1 = commonService.selectCalendar();
			model.addAttribute("list1", list1);
			
			return list1; 
		}
		
		//캘린더 데이터 삭제
			@ResponseBody
			@RequestMapping(value = "/deleteAjax.do")
			public int deleteAjax(Model model, CalendarVO calendarVO) {
				return commonService.deleteCalendar(calendarVO); 
			}
			
		//캘린더 월별조회
		@ResponseBody
		@RequestMapping(value = "/selectMonth.do")
		public List<CalendarVO> selectMonth(Model model, CalendarVO calendarVO) {
			
			
			
			return commonService.selectCalendar1(calendarVO);
		}
			
		
		//캘린더 데이터 입력
		@RequestMapping(value = "/calendar.do")
		public String calendar(MenuSideDetailVO menuSideDetailVO, CalendarVO calendarVO, Model model, RedirectAttributes re) {
			commonService.insertCalendar(calendarVO);
			re.addAttribute("mainNum" ,menuSideDetailVO.getMainNum());
			re.addAttribute("sideNum" ,menuSideDetailVO.getSideNum());
			re.addAttribute("sideDetailNum" ,menuSideDetailVO.getSideDetailNum());
			return "redirect:adminCal.do"; 
		}
		
}










