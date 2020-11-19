package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.CalendarVO;
import com.spring.biz.vo.MenuSideDetailVO;
import com.spring.biz.vo.MenuSideVO;
import com.spring.biz.vo.MenuVO;

@Service("menuService") 
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MenuVO> mainMenu(MenuSideDetailVO menuSideDetailVO) {
	
		return sqlSession.selectList("mainMenu", menuSideDetailVO);
	}
	@Override
	public List<MenuVO> mainMenuSide(MenuSideDetailVO menuSideDetailVO) {
		
		return sqlSession.selectList("mainMenuSide", menuSideDetailVO);
	}


	@Override
	public List<MenuSideVO> sideMenu(MenuSideDetailVO menuSideDetailVO) {
		
		return sqlSession.selectList("sideMenu", menuSideDetailVO);
	}

	@Override
	public List<MenuSideDetailVO> sideDetailMenu(MenuSideDetailVO menuSideDetailVO) {
		
		return sqlSession.selectList("sideDetailMenu", menuSideDetailVO);
	}

	@Override
	public List<MenuSideDetailVO> menuLocation(MenuSideDetailVO menuSideDetailVO) {
		
		return sqlSession.selectList("menuLocation", menuSideDetailVO);
	}
	
}












