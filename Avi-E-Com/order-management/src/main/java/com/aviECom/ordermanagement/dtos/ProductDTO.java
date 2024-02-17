package com.aviECom.ordermanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO{
	private Long productId;
	
	private String productUuid;
	
	private String productName;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
}
