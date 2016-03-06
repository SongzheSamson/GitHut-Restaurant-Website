package com.restaurant.service;

import java.util.Collection;

import com.restaurant.domain.Users;

public interface UsersService {
	public void addUsers(Users users);
	public void deleteUsers(Users users);
	public Users getUsers(String username);
	public Collection<Users> list();
	public Collection<Users> listCustomer();
	public Collection<Users> listManager();
}
