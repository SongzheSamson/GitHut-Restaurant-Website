package com.restaurant.myweb;

import java.util.Set;

import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.domain.Authorities;
import com.restaurant.domain.Customer;
import com.restaurant.domain.Users;
import com.restaurant.service.AuthoritiesService;
import com.restaurant.service.AuthoritiesServiceImp;
import com.restaurant.service.CustomerService;
import com.restaurant.service.UsersService;
import com.restaurant.util.RegisterUser;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String admin(Model model){
		model.addAttribute("usersCustomer", usersService.listCustomer());
		model.addAttribute("usersManager", usersService.listManager());
		
		return "admin";
	}
	@RequestMapping(value="{username}/edit", method= RequestMethod.GET)
	public String edit(@PathVariable String username, Model model){
		Users users = usersService.getUsers(username);
		Customer customer = users.getCustomer();
		RegisterUser registerUser = new RegisterUser(users,customer);
		
		model.addAttribute(registerUser);
		return "userEdit";
		
	}
	
	@RequestMapping(value="{username}/edit", method= RequestMethod.POST)
	public String update(@PathVariable String username, Model model, @Valid RegisterUser registerUser, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "userEdit";
		}
		
		
		Users users = usersService.getUsers(username);
		Customer customer = users.getCustomer();
		Set<Authorities> authorities = users.getAuthoritieses();
		
		users.setUsername(registerUser.getUsername());
		users.setPassword(registerUser.getPassword());
		users.setEnabled(true);

		customer.setFirstName(registerUser.getFirstName());
		customer.setLastName(registerUser.getLastName());
		customer.setAddress(registerUser.getAddress());
		customer.setEmail(registerUser.getEmail());
		customer.setPhone(registerUser.getPhone());
		
		customer.setUsers(users);
		
		users.setCustomer(customer);
		
		customerService.addCustomer(customer);
		
		return "redirect:/admin";
		
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerManagerPage(Model model){
		
		model.addAttribute(new RegisterUser());
		return "registerManager";
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerManager(Model model, @Valid RegisterUser registerUser, BindingResult bindingResult){
		
			if(bindingResult.hasErrors()){
				return "registerManager";
			}
			Users users = new Users();
			Customer customer = new Customer();
			Authorities authorities = new Authorities();
			
			users.setUsername(registerUser.getUsername());
			users.setPassword(registerUser.getPassword());
			System.out.println("users:" + users);
			
			authorities.setUsername(registerUser.getUsername());
			authorities.setAuthority("ROLE_MANAGER");
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
			
			customerService.addCustomer(customer);
			authoritiesService.addAuthorities(authorities);
			
			return "redirect:/admin";
		
	}
}
