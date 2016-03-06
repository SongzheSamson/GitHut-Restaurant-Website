package com.restaurant.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.domain.Authorities;
import com.restaurant.domain.Users;

@Repository
public class AuthoritiesDAOhibernateImp implements AuthoritiesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAuthorities(Authorities authorities) {
		sessionFactory.getCurrentSession().save(authorities);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteAuthorities(Authorities suthorities) {
		sessionFactory.getCurrentSession().delete(suthorities);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public Authorities getAuthorities(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Authorities.class);

		criteria.add(Restrictions.eqOrIsNull("username", username));

		return (Authorities) criteria.uniqueResult();
		
	}

	@Override
	public Collection<Authorities> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
