package com.restaurant.myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.service.OrderService;



@Controller
@RequestMapping("orderList")
public class OrderListController {
	
	@Autowired
	private OrderService orderService;
		@RequestMapping(method = RequestMethod.GET)
		public String orderList(Model model){
			model.addAttribute("orders",orderService.listOrder() );
			return "orderList";
		}
}
