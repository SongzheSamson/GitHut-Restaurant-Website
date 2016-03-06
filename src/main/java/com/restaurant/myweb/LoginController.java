package com.restaurant.myweb;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.util.RegisterUser;

@Controller
@RequestMapping("/userLogin")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model,@RequestParam (value="error",required=false) String error){
			
		
		if(error!=null)
		{
			model.addAttribute("error", "Invalid username and password!");
		}
		
		return "login";
	}
	
	@RequestMapping(value = "error")
	public String error(Model model){
		
		model.addAttribute("error", "Invalid username / password");
		return "login";
	}
	
	
}
