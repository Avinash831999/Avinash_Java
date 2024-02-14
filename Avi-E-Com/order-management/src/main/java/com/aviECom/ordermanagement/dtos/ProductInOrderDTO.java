package com.aviECom.ordermanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInOrderDTO {
	private Long id;
	private int quantity;
}
