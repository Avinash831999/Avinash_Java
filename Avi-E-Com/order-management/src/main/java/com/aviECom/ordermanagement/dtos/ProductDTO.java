package com.aviECom.ordermanagement.dtos;

import lombok.Data;

@Data
public class ProductDTO{
	private Long product_id;
	
	private String product_uuid;
	
	private String product_name;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
}
