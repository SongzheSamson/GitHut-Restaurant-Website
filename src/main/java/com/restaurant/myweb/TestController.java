package com.restaurant.myweb;

import java.util.Collection;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.domain.Menu;
import com.restaurant.domain.Customer;
import com.restaurant.service.MenuService;


@Controller
@RequestMapping("/test")
public class TestController {
		
		@Autowired
		private MenuService menuService;
		
	
		
		@RequestMapping(value = "test",method = RequestMethod.GET)
		public String testDAO(Model model){
			
			
		//	userService.addUser(user);
		
			
			
			
			
			
			return "success";
			
		}
}
