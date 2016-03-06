package com.restaurant.myweb;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.restaurant.domain.Customer;
import com.restaurant.domain.Food;
import com.restaurant.domain.Menu;
import com.restaurant.domain.MenuFood;
import com.restaurant.domain.Order;
import com.restaurant.domain.OrderFood;
import com.restaurant.service.FoodService;
import com.restaurant.service.MenuService;
import com.restaurant.service.OrderService;
import com.restaurant.service.UsersService;

@Controller
@RequestMapping(value ="/orders")
@SessionAttributes(value = {"order", "menu"})
public class OrderController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private OrderService orderService;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping(value = "{menuId}",method = RequestMethod.GET)
	public String order(@PathVariable Integer menuId, Model model){
		
		Menu menu = menuService.getMenu(menuId);
		model.addAttribute(new OrderFood());
		
		
		model.addAttribute(menu);
		
			
			model.addAttribute(new Order());
		
		
		model.addAttribute("menuFoodList", Collections.unmodifiableSet(menu.getMenuFood()) );
		
		return "order";
		
	}
	@RequestMapping(value = "{menuId}/add",method = RequestMethod.GET)
	public String order1(@PathVariable Integer menuId, Model model,@ModelAttribute Order order){
		
		Menu menu = menuService.getMenu(menuId);
		model.addAttribute(new OrderFood());
		
		
		
		if(order==null){
			
			model.addAttribute(new Order());
		}else{
			model.addAttribute(order);
		}
		Double totlePrice = 0.0;
		for (OrderFood orderF: order.getOrderFoodList()){
			totlePrice += orderF.getPrice() * orderF.getNumber();
			
		}
		order.setTotlePrice(totlePrice);
		model.addAttribute("menuFoodList", Collections.unmodifiableSet(menu.getMenuFood()) );
		
		return "order";
		
	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String orderPage(Model model){
//		
//		model.addAttribute(new Order());
//		return "orderPage";
//		
//	}
	
	@RequestMapping(value = "{menuId}/addFood")
	public String orderAddFood(@PathVariable Integer menuId,@ModelAttribute Order order, @Valid OrderFood orderFood,BindingResult bindingResult, Model model){
		Menu menu = menuService.getMenu(menuId);
		model.addAttribute("menuFoodList", Collections.unmodifiableSet(menu.getMenuFood()) );
		if(bindingResult.hasErrors()){
			
			return "order";
		}
		
		order.addOrderFoodToList(orderFood);
		
		model.addAttribute(order);
		
		return "redirect:/orders/"+ menuId +"/add";
	}
	@RequestMapping(value = "{index}/deleteFood", method  = RequestMethod.GET)
	public String deleteFood(@PathVariable int index, Model model, OrderFood orderFood, @ModelAttribute Order order, @ModelAttribute Menu menu){
		
		
		
		order.getOrderFoodList().remove(index);
		
		model.addAttribute(order);
		return "redirect:/orders/"+ menu.getMenuId() + "/add";
	}
	
	@RequestMapping(value = "updateFood")
	public String updateFood(@RequestParam int index, @RequestParam int number, Model model,@ModelAttribute Menu menu,@ModelAttribute Order order){
		OrderFood orderFood = order.getOrderFoodList().get(index);
		orderFood.setNumber(number);
		model.addAttribute(order);
		
		return "redirect:/orders/"+ menu.getMenuId() +"/add";
		
	}
	@RequestMapping(value="orderInformation")
	public String orderInformation(@ModelAttribute Order order, Model model){
		System.out.println(order.getOrderFoods());
		
		
		
		return "orderInfo";
		
	}
	@RequestMapping(value = "sendOrder")
	public String sendOrder(Model model, @Valid Order order, BindingResult bindingResult,@ModelAttribute Menu menu){
		if(bindingResult.hasErrors()){
			return "orderInfo";
		}
		Set<OrderFood> setNew = new HashSet<>();
		for (OrderFood orderFood: order.getOrderFoods()){
			orderFood.setOrder(order);
			setNew.add(orderFood);
		}
		order.setOrderFoods(setNew);
		orderService.addOrder(order);

		return "redirect:/orders/"+ menu.getMenuId()+"/succeed";
		
	}
	@RequestMapping(value = "autoFill")
	public String autoFill(Model model, @ModelAttribute Order order){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer = usersService.getUsers(username).getCustomer();
		order.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
		order.setAddress(customer.getAddress());
		order.setPhoneNumber(customer.getPhone());
		model.addAttribute(order);
		return "orderInfo";
	}
	@RequestMapping(value="{menuId}/succeed")
	public String sendSucceed (@PathVariable Integer menuId, Model model){
		model.addAttribute(new Order());
		model.addAttribute(new OrderFood());
		model.addAttribute("menuFoodList",menuService.getMenu(menuId).getMenuFood());
		model.addAttribute("succeed", "Order has been sent!");
		return "order";
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
