package com.restaurant.service;

import java.util.Collection;

import com.restaurant.domain.Customer;

public interface CustomerService {
	public Customer getCustomer(Integer id);
	public void deleteCustomer(Customer customer);
	public Collection<Customer> list();
	public void addCustomer(Customer customer);
}
