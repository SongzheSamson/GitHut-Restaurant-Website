package com.restaurant.dao;

import java.util.Collection;

import com.restaurant.domain.Order;

public interface OrderDAO {
	public Order getOrder(Integer orderId);
	public void addOrder(Order order);
	public Collection<Order> listOrder();
	public void deleteOrder(Order order);
}
