package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.dao.AuthoritiesDAO;
import com.restaurant.domain.Authorities;
@Service
public class AuthoritiesServiceImp implements AuthoritiesService {
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Override
	@Transactional
	public void addAuthorities(Authorities authorities) {
		authoritiesDAO.addAuthorities(authorities);

	}

	@Override
	@Transactional
	public void deleteAuthorities(Authorities authorities) {
		authoritiesDAO.deleteAuthorities(authorities);
	}

	@Override
	public Authorities getAuthorities(String username) {
		
		return authoritiesDAO.getAuthorities(username);
	}

}
