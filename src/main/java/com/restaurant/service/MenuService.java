package com.restaurant.service;

import java.util.Collection;

import com.restaurant.domain.Menu;

public interface MenuService {
	public void addMneu(Menu menu);
	public Menu getMenu(Integer menuId);
	public Collection<Menu> listMenu();
	public void deleteMenu(Menu menu);
}
