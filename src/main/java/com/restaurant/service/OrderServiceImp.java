package com.restaurant.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.OrderDAO;
import com.restaurant.domain.Order;
@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	@Transactional
	public Order getOrder(Integer orderId) {
		
		return orderDAO.getOrder(orderId);
	}

	@Override
	@Transactional
	public void addOrder(Order order) {
		orderDAO.addOrder(order);

	}

	@Override
	@Transactional
	public Collection<Order> listOrder() {
		
		return orderDAO.listOrder();
	}

	@Override
	@Transactional
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);

	}

}
