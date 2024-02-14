package com.aviECom.ordermanagement.controllersImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviECom.ordermanagement.controllers.OrderController;
import com.aviECom.ordermanagement.dtos.OrderRequestDto;
import com.aviECom.ordermanagement.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderControllerImpl implements OrderController{
	
	private final OrderService orderService;
	
	public OrderControllerImpl(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@PostMapping("/placeOrder")
	@Override
	public OrderRequestDto placeOrder(@RequestBody OrderRequestDto orderReq) {
		return this.orderService.placeOrder(orderReq);
	}
}
