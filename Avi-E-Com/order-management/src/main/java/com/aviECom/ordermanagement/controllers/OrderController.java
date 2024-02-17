package com.aviECom.ordermanagement.controllers;

import java.util.List;

import com.aviECom.ordermanagement.dtos.OrderRequestDto;
import com.aviECom.ordermanagement.dtos.OrderResponseDto;

public interface OrderController {
	
	public OrderRequestDto placeOrder(OrderRequestDto orderReq);
	
	public List<OrderResponseDto> getUsersOrder(Long User_id);
	
}
