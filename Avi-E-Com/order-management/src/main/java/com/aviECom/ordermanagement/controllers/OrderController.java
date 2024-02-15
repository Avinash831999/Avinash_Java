package com.aviECom.ordermanagement.controllers;

import com.aviECom.ordermanagement.dtos.OrderRequestDto;

public interface OrderController {
	
	public OrderRequestDto placeOrder(OrderRequestDto orderReq);
	
}
