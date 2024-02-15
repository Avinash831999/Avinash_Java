package com.aviECom.productmanagement.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProductDTO{
	private Long id;
	
	private String productId;
	
	private String product_name;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updated_date;
}
