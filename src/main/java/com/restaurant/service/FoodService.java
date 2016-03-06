package com.restaurant.service;

import java.util.Collection;

import com.restaurant.domain.Food;

public interface FoodService {
	public void addFood(Food food);
	public Collection<Food> listFood();
	public Food getFood(Integer foodId);
}
