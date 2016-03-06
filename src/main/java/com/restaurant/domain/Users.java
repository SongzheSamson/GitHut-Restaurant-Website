package com.restaurant.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "users")
public class Users {

	@Id
	@NotEmpty
	@Column(name = "username", unique = true,length=50)
	private String username;
	
	@NotEmpty
	@Column(name = "password",length = 50)
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Authorities> authoritieses;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Customer customer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthoritieses() {
		return authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addAuthorities(Authorities authorities){
		this.authoritieses.add(authorities);
	}
}
