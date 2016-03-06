package com.restaurant.dao;

import java.util.Collection;


import com.restaurant.domain.Menu;

public interface MenuDAO {
	public void addMneu(Menu menu);
	public Menu getMenu(Integer menuId);
	public Collection<Menu> listMenu();
	public void deleteMenu(Menu menu);
}
