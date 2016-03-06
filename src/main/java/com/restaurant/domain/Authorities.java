package com.restaurant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "authorities",uniqueConstraints = @UniqueConstraint(columnNames = { "username",
"authority" }) )
public class Authorities {
	@Id
	@NotEmpty
	@Column(name = "username", unique = true,nullable = false,length=50)
	private String username;
	
	@NotEmpty
	@Column(name= "authority",nullable = false,length=50)
	private String authority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username",insertable = false, updatable = false)
	private Users users;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
