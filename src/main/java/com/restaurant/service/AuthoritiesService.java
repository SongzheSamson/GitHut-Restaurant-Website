package com.restaurant.service;

import com.restaurant.domain.Authorities;

public interface AuthoritiesService {
	public void addAuthorities(Authorities authorities);
	public void deleteAuthorities(Authorities suthorities);
	public Authorities getAuthorities(String username);
}
