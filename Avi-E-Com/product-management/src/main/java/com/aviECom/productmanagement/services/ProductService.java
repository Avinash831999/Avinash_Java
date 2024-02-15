package com.aviECom.productmanagement.services;

import com.aviECom.productmanagement.dtos.ProductDTO;


public interface ProductService {
	
	public Long addProduct(ProductDTO product);
	
	public ProductDTO updateProduct(ProductDTO product);
	
	public void deleteProduct(Long product_id);
	
	public ProductDTO getProductDetails(Long product_id);
}
