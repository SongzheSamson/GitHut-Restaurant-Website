package com.restaurant.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.FoodDAO;
import com.restaurant.domain.Food;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	@Qualifier("foodDAOhibernateImp")
	FoodDAO foodDAO;
	
	@Override
	@Transactional
	public void addFood(Food food) {
		foodDAO.addFood(food);

	}

	@Override
	@Transactional
	public Collection<Food> listFood() {
		
		return foodDAO.listFood();
	}

	@Override
	@Transactional
	public Food getFood(Integer foodId) {
		
		return foodDAO.getFood(foodId);
	}

}
