package com.restaurant.myweb;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.domain.Food;
import com.restaurant.domain.Menu;
import com.restaurant.domain.MenuFood;
import com.restaurant.service.FoodService;
import com.restaurant.service.MenuFoodService;
import com.restaurant.service.MenuService;
@Controller
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private MenuFoodService menuFoodService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listMenu(Model model){
		model.addAttribute(new Menu());
		model.addAttribute("menuList", menuService.listMenu());
		return "menus";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createMenu(Model model, @Valid Menu menu, BindingResult bindingResult ){
		if(bindingResult.hasErrors()){
			model.addAttribute("menuList", menuService.listMenu());
			return "menus";
		}
		
		menuService.addMneu(menu);
		return "redirect:/menus";
	}
	@RequestMapping(value = "/{menuId}/edit", method = RequestMethod.GET)
	public String liseMenuFood(@PathVariable Integer menuId, Model model){
		
		Menu menu = menuService.getMenu(menuId);
		model.addAttribute(new MenuFood());
		model.addAttribute(foodService.listFood());
		model.addAttribute("menuFoodList", menu.getMenuFood());
		
		
		return "editMenu";
		
	}
	
	@RequestMapping(value="/{menuId}/{foodId}/photo", method = RequestMethod.GET)
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
	@RequestMapping(value = "/{menuId}/addFood")
	public String addFood(@PathVariable Integer menuId, @Valid MenuFood menuFood, BindingResult bindingResult, Model model ){
		if(bindingResult.hasErrors()){
			
			model.addAttribute(foodService.listFood());
			model.addAttribute("menuFoodList", menuService.getMenu(menuId).getMenuFood());
			return "editMenu";
		}
		
		Menu menu = menuService.getMenu(menuId);
		
		menu.addMenuFood(menuFood);
		
		menuFood.setMenu(menu);
		menuService.addMneu(menu);
		
		return "redirect:/menus/" + menuId + "/edit";

	}
	@RequestMapping(value = "/{menuId}/{menuFoodId}/removeFood")
	public String removeFood(@PathVariable Integer menuId, @PathVariable Integer menuFoodId, Model model){
		
		
		MenuFood menuFood = menuFoodService.getMenuFood(menuFoodId);
		System.out.println("++++++++++++++++"+menuFood);
		Menu menu = menuFood.getMenu();
//		Food food = menuFood.getFood();
		System.out.println("Before remove"+menu.getMenuFood());
		menu.removeMenuFood(menuFood);
		System.out.println("After remove"+ menu.getMenuFood());

		menuService.addMneu(menu);
		
		menuFoodService.removeMenuFood(menuFoodId);
//		foodService.addFood(food);
		
		return "redirect:/menus/" + menuId + "/edit";
		
	}
	@RequestMapping(value = "/{menuId}/removeMenu")
	public String removeMenu(@PathVariable Integer menuId, Model model){
		
		Menu menu = menuService.getMenu(menuId);
		menuService.deleteMenu(menu);
		
		return "redirect:/menus";
		
	}
}
