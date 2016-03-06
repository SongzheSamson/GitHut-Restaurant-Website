package com.restaurant.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.Customer;
@Repository
public class CustomerDAOhibernateImp implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Customer getCustomer(Integer id) {
		
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);

	}

	@Override
	public Collection<Customer> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		sessionFactory.getCurrentSession().flush();
	}

}
