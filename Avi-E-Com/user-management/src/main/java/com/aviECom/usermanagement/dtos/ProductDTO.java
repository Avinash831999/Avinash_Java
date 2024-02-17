package com.aviECom.usermanagement.dtos;

import lombok.Data;

@Data
public class ProductDTO{
	private Long productId;
	
	private String productUuid;
	
	private String productName;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
}
