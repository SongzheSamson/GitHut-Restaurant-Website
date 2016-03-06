package com.restaurant.dao;

import java.util.Collection;

import com.restaurant.domain.Authorities;

public interface AuthoritiesDAO {
	public void addAuthorities(Authorities authorities);
	public void deleteAuthorities(Authorities suthorities);
	public Authorities getAuthorities(String username);
	public Collection<Authorities> list();
}
