package com.aviECom.ordermanagement.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
	private Long userId;
	private Set<ProductInOrderDTO> products;
	private String modeOfDelivery;
	private String address;
}
