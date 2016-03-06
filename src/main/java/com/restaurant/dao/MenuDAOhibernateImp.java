package com.restaurant.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.Menu;
@Repository
public class MenuDAOhibernateImp implements MenuDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMneu(Menu menu) {
		sessionFactory.getCurrentSession().save(menu);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public Menu getMenu(Integer menuId) {
		
		return (Menu) sessionFactory.getCurrentSession().get(Menu.class, menuId);
	}

	@Override
	public Collection<Menu> listMenu() {
		
		return sessionFactory.getCurrentSession().createQuery("from Menu").list();
	}

	@Override
	public void deleteMenu(Menu menu) {
		
			Session session = sessionFactory.getCurrentSession();
			session.delete(menu);
			session.flush();
			
			System.out.print("delete was procceed");
		
		

	}

}
