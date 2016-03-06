package com.restaurant.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import com.restaurant.domain.Customer;
import com.restaurant.domain.Users;

public class RegisterUser {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String address;
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@NumberFormat
	private String phone;
	
	public RegisterUser() {
		super();
	}
	public RegisterUser(Users users, Customer customer){
		this.username= users.getUsername();
		this.password=users.getPassword();
		this.firstName= customer.getFirstName();
		this.lastName= customer.getLastName();
		this.address= customer.getAddress();
		this.email=customer.getEmail();
		this.phone=customer.getPhone();
	}
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
