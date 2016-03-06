package com.restaurant.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.Authorities;
import com.restaurant.domain.Users;
@Repository
public class UsersDAOhibernateImp implements UsersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addUsers(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteUsers(Users users) {
		sessionFactory.getCurrentSession().delete(users);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Users getUsers(String username) {
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Users.class);
		
		criteria.add(Restrictions.eqOrIsNull("username", username));
		
		return (Users) criteria.uniqueResult();
	}

	@Override
	public Collection<Users> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	public Collection<Users> listCustomer() {
		// TODO Auto-generated method stub
		Collection<Authorities> authorites = sessionFactory.getCurrentSession().createQuery("from Authorities where authority='ROLE_CUSTOMER' ").list();
		Collection<Users> users = new HashSet<Users>();
		
		for(Authorities au : authorites){
			
			users.add(au.getUsers());
		}
		
		return users;
	}

	@Override
	public Collection<Users> listManager() {
		Collection<Authorities> authorites = sessionFactory.getCurrentSession().createQuery("from Authorities where authority='ROLE_MANAGER' ").list();
		Collection<Users> users = new HashSet<Users>();
		
		for(Authorities au : authorites){
			
			users.add(au.getUsers());
		}
		System.out.println("listManager:" + users.size());
		return users;
	}

}
