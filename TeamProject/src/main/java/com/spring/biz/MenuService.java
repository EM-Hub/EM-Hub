package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.BoardVO;
import com.spring.biz.vo.CalendarVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MenuVO;

public interface MenuService {
	//상단 메뉴 
	List<MenuVO> mainMenu(MenuSideDetailVO menuSideDetailVO);
	//상단메뉴 - 사이드
	List<MenuVO> mainMenuSide(MenuSideDetailVO menuSideDetailVO);
	//상단메뉴 - 하위메뉴 드롭다운 
	List<MenuSideVO> sideMenu(MenuSideDetailVO menuSideDetailVO);
	//하위메뉴 안에 메뉴
	List<MenuSideDetailVO> sideDetailMenu(MenuSideDetailVO menuSideDetailVO);
	//페이지 이동 시 메뉴위치?
	List<MenuSideDetailVO> menuLocation(MenuSideDetailVO menuSideDetailVO);
	
}




















