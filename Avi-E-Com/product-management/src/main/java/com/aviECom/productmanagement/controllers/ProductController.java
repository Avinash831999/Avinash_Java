package com.aviECom.productmanagement.controllers;

import org.springframework.http.ResponseEntity;
import com.aviECom.productmanagement.dtos.ProductDTO;
import com.aviECom.productmanagement.dtos.ResponseDTO;


public interface ProductController {

	
	public ResponseEntity<ResponseDTO> addProduct(ProductDTO productdto);
	
	
	public ResponseEntity<ProductDTO> getProductDetails( Long product_id);
	
	
	public ResponseEntity<ProductDTO> updateProduct( ProductDTO productdto);
	
	
	public ResponseEntity<ResponseDTO> deleteProduct( Long product_id);
	
	
}
