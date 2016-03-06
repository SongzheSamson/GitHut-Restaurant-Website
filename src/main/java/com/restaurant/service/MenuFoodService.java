package com.restaurant.service;

import com.restaurant.domain.MenuFood;

public interface MenuFoodService {
	public void removeMenuFood(Integer id);
	public MenuFood getMenuFood(Integer id);
}
