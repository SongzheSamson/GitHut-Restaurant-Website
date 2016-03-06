package com.restaurant.myweb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.domain.Authorities;
import com.restaurant.domain.Customer;
import com.restaurant.domain.Users;
import com.restaurant.service.AuthoritiesServiceImp;
import com.restaurant.service.CustomerServiceImp;
import com.restaurant.util.RegisterUser;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	CustomerServiceImp customerServiceImp;
	@Autowired
	AuthoritiesServiceImp authoritiesServiceImp;
	@RequestMapping(method = RequestMethod.GET)
	public String register(Model model, RegisterUser registerUser) {
		model.addAttribute(new RegisterUser());
		return "register";
	}
	@RequestMapping(method= RequestMethod.POST)
	public String registerPost(Model model, @Valid RegisterUser registerUser, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "register";
		}
		Users users = new Users();
		Customer customer = new Customer();
		Authorities authorities = new Authorities();
		
		users.setUsername(registerUser.getUsername());
		users.setPassword(registerUser.getPassword());
		users.setEnabled(true);
		System.out.println("users:" + users);
		
		authorities.setUsername(registerUser.getUsername());
		authorities.setAuthority("ROLE_CUSTOMER");
		System.out.println("Authorities: "+ authorities );
		
		customer.setFirstName(registerUser.getFirstName());
		customer.setLastName(registerUser.getLastName());
		customer.setAddress(registerUser.getAddress());
		customer.setEmail(registerUser.getEmail());
		customer.setPhone(registerUser.getPhone());
		System.out.println("Customer : " + customer);
		
		
		
		authorities.setUsers(users);
		//users.addAuthorities(authorities);
		
		customer.setUsers(users);
		
		users.setCustomer(customer);
		
		customerServiceImp.addCustomer(customer);
		authoritiesServiceImp.addAuthorities(authorities);
		
		return "login";
	}
}
