package com.restaurant.myweb;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.domain.Food;
import com.restaurant.domain.Menu;
import com.restaurant.service.FoodService;
import com.restaurant.service.MenuService;



@Controller
@RequestMapping("/foods")
public class FoodController {
	@Autowired
	@Qualifier("foodServiceImp")
	FoodService foodService;
	
	@Autowired
	@Qualifier("menuServiceImp")
	private MenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listFoods(Model model) {
		model.addAttribute(new Food());
		model.addAttribute("foodList", foodService.listFood());
		return "foods";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String addFoods(@Valid Food food, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			
			model.addAttribute("foodList", foodService.listFood());
			
			return "foods";
		}
		foodService.addFood(food);
	
		return "redirect:/foods";
		
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
