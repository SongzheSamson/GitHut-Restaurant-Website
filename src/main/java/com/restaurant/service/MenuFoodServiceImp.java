package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.MenuFoodDAO;
import com.restaurant.domain.MenuFood;
@Service
public class MenuFoodServiceImp implements MenuFoodService {
	
	@Autowired
	@Qualifier("menuFoodDAOhibernateImp")
	private MenuFoodDAO menuFoodDAO;
	
	@Override
	@Transactional
	public void removeMenuFood(Integer id) {
		menuFoodDAO.removeMenuFood(id);

	}

	@Override
	@Transactional
	public MenuFood getMenuFood(Integer id) {
		
		return menuFoodDAO.getMenuFood(id);
	}

}
