package com.aviECom.ordermanagement.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
	private long orderId;
	private String orderUuid;
	private Long userId;
	private String address;
	private LocalDateTime orderedDate;

	private String modeOfDelivery;

	private double totalAmount;
	private LocalDateTime expectedDeliveryDate;
	private LocalDateTime deliveredDate;

	private String orderStatus;
	Set<ProductDTO> productsOrdered;
}
