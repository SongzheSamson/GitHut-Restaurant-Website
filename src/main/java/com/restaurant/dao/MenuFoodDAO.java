package com.restaurant.dao;

import com.restaurant.domain.MenuFood;

public interface MenuFoodDAO {
	public void removeMenuFood(Integer id);
	public MenuFood getMenuFood(Integer id);
	
}
