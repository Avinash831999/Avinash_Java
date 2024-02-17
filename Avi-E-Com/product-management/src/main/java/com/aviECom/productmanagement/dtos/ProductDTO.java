package com.aviECom.productmanagement.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProductDTO{
	private Long id;
	
	private String productUuid;
	
	private String productName;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedDate;
}
