package com.aviECom.ordermanagement.services.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aviECom.ordermanagement.dtos.ProductDTO;



@FeignClient("product-management")
public interface ProductFeignClient {
	
	@GetMapping("/api/product/get/{product_id}")
	public ResponseEntity<ProductDTO> getProductDetails(@PathVariable Long product_id);
}
