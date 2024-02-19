package com.aviECom.productmanagement.controllers.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviECom.productmanagement.constants.ProductManagementConstants;
import com.aviECom.productmanagement.controllers.ProductController;
import com.aviECom.productmanagement.dtos.ProductDTO;
import com.aviECom.productmanagement.dtos.ResponseDTO;
import com.aviECom.productmanagement.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductControllerImpl implements ProductController{


	private ProductService productService;
	

	public ProductControllerImpl(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/add")
	@Override
	public ResponseEntity<ResponseDTO> addProduct(@RequestBody ProductDTO productdto) {
		this.productService.addProduct(productdto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDTO("Product Successfully created!", ProductManagementConstants.product_created));
	}

	@GetMapping("/get/{product_id}")
	@Override
	public ResponseEntity<ProductDTO> getProductDetails(@PathVariable Long product_id) {
		ProductDTO productDto = this.productService.getProductDetails(product_id);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(productDto);
	}

	@PostMapping("/update")
	@Override
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productdto) {
		ProductDTO productDto = this.productService.updateProduct(productdto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(productDto);
	}

	@DeleteMapping("/delete/{product_id}")
	@Override
	public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable Long product_id) {
		this.productService.deleteProduct(product_id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseDTO("Product Deleted", ProductManagementConstants.product_deleted));
	}

}
