package com.restaurant.dao;

import java.util.Collection;

import com.restaurant.domain.Food;

public interface FoodDAO {
	public void addFood(Food food);
	public Collection<Food> listFood();
	public Food getFood(Integer foodId);
}
