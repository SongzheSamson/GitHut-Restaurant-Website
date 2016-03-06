package com.restaurant.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.CustomerDAO;
import com.restaurant.domain.Customer;
@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);

	}

	@Override
	@Transactional
	public Collection<Customer> list() {
		
		return customerDAO.list();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);

	}

}
