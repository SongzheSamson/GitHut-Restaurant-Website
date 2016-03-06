package com.restaurant.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurant.domain.Order;

@Repository
public class OrderDAOhibernateImp implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Order getOrder(Integer orderId) {
		
		return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
	}

	@Override
	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);

	}

	@Override
	public Collection<Order> listOrder() {
		
		return sessionFactory.getCurrentSession().createQuery("from Order order by orderTime desc").list();
	}

	@Override
	public void deleteOrder(Order order) {
		Session session =sessionFactory.getCurrentSession();
		session.delete(order);
		session.flush();

	}

}
