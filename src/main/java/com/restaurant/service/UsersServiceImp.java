package com.restaurant.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.UsersDAO;
import com.restaurant.domain.Users;
@Service
public class UsersServiceImp implements UsersService {

	@Autowired
	private UsersDAO usersDAO;
	@Override
	@Transactional
	public void addUsers(Users users) {
		usersDAO.addUsers(users);

	}

	@Override
	@Transactional
	public void deleteUsers(Users users) {
		usersDAO.deleteUsers(users);

	}

	@Override
	@Transactional
	public Users getUsers(String username) {
		
		return usersDAO.getUsers(username);
	}

	@Override
	@Transactional
	public Collection<Users> list() {
		
		return usersDAO.list();
	}

	@Override
	@Transactional
	public Collection<Users> listCustomer() {
		
		return usersDAO.listCustomer();
	}

	@Override
	@Transactional
	public Collection<Users> listManager() {
		
		return usersDAO.listManager();
	}

}
