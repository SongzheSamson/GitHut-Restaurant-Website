package com.restaurant.myweb;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.domain.Food;
import com.restaurant.domain.Menu;
import com.restaurant.service.FoodService;
import com.restaurant.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private FoodService foodService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		
		return "home";
	}
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public String menuList(Model model){
		Collection<Menu> menus = menuService.listMenu();
		model.addAttribute("menus", menus);
		
		return "menuList";
	}
	
	@RequestMapping(value="/{foodId}/photo", method = RequestMethod.GET)
	public @ResponseBody String viewPhoto ( @PathVariable Integer foodId, HttpServletResponse response ) throws IOException{
		
		Food food = foodService.getFood(foodId);
		byte[] photoBytes = food.getPhotoBytes();
		
		if (photoBytes != null) {
			int photoLength = photoBytes.length;
			try (ServletOutputStream sos = response.getOutputStream()) {
				response.setContentType(food.getPhotoContentType());
				response.setContentLength(photoLength);
				response.setHeader("Content-Disposition", "inline; filename=\"" + food.getPhotoFilename() + "\"");
				
				sos.write(photoBytes);
				sos.flush();
			}
		}
		return "";
		
	}
	
}
