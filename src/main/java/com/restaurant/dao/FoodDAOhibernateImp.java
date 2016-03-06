package com.restaurant.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.Food;
@Repository	
public class FoodDAOhibernateImp implements FoodDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void addFood(Food food) {
		sessionFactory.getCurrentSession().save(food);
	}

	@Override
	public Collection<Food> listFood() {
		
		return sessionFactory.getCurrentSession().createQuery("from Food").list();
	}

	@Override
	public Food getFood(Integer foodId) {
		
		return (Food) sessionFactory.getCurrentSession().get(Food.class, foodId);
	}

}
