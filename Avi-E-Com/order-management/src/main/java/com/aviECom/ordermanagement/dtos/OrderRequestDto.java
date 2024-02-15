package com.aviECom.ordermanagement.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
	private Long user_id;
	private Set<ProductInOrderDTO> products;
	private String mode_of_delivery;
	private String address;
}