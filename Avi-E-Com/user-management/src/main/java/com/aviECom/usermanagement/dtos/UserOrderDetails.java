package com.aviECom.usermanagement.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;

@Data
public class UserOrderDetails {
	private long orderId;
	private String orderUuid;
	private String userId;
	private String address;
	private LocalDateTime orderedDate;

	private String modeOfDelivery;

	private double totalAmount;
	private LocalDateTime expectedDeliveryDate;
	private LocalDateTime delivereDdate;

	private String orderStatus;
	Set<ProductDTO> productsInOrder;
}
