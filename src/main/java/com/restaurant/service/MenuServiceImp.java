package com.restaurant.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.MenuDAO;
import com.restaurant.domain.Menu;
@Service
public class MenuServiceImp implements MenuService {
	@Autowired
	@Qualifier("menuDAOhibernateImp")
	MenuDAO menuDAO;
	
	@Override
	@Transactional
	public void addMneu(Menu menu) {
		menuDAO.addMneu(menu);

	}

	@Override
	@Transactional
	public Menu getMenu(Integer menuId) {
		
		return menuDAO.getMenu(menuId);
	}

	@Override
	@Transactional
	public Collection<Menu> listMenu() {
		
		return menuDAO.listMenu();
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteMenu(Menu menu) {
		
		menuDAO.deleteMenu(menu);

	}

}
