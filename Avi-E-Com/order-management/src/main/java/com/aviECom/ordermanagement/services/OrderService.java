package com.aviECom.ordermanagement.services;

import java.util.List;

import com.aviECom.ordermanagement.dtos.OrderRequestDto;
import com.aviECom.ordermanagement.dtos.OrderResponseDto;

public interface OrderService {

	public OrderRequestDto placeOrder(OrderRequestDto orderReq);
	
	public OrderResponseDto cancelOrder(Long orderId);
	
	public OrderResponseDto deliverOrder(Long orderId);
	
	public List<OrderResponseDto> getUsersOrder(long user_id);
	
//	public List<OrderResponseDto> getOrderstoDeliver();
//	
//	public List<OrderResponseDto> getCancelledOrders();
	
	
}
