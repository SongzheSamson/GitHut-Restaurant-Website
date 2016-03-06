package com.restaurant.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.MenuFood;
@Repository
public class MenuFoodDAOhibernateImp implements MenuFoodDAO {
	@Autowired
	SessionFactory sessionFactory;

	
	public void removeMenuFood(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		MenuFood menuFood = (MenuFood) session.get(MenuFood.class, id);
		session.delete(menuFood);
		session.flush();
		
	}


	@Override
	public MenuFood getMenuFood(Integer id) {
		
		return (MenuFood) sessionFactory.getCurrentSession().get(MenuFood.class, id);
	}



}
