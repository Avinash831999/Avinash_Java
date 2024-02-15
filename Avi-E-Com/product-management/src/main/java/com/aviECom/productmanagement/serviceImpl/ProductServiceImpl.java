package com.aviECom.productmanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.aviECom.productmanagement.dtos.ProductDTO;
import com.aviECom.productmanagement.entity.ProductEntity;
import com.aviECom.productmanagement.exceptions.ProductNotFoundException;
import com.aviECom.productmanagement.repositories.ProductRepository;
import com.aviECom.productmanagement.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		this.productRepo = productRepo;
		
	}
	
	@Override
	public Long addProduct(ProductDTO product) {
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProduct_name(product.getProduct_name());
		productEntity.setCategory(product.getCategory());
		productEntity.setGender(product.getGender());
		productEntity.setPrice(product.getPrice());
		productEntity.setDiscount(product.getDiscount());
		
		productEntity.setProductId(UUID.randomUUID().toString());
		
		productEntity.setCreated_date(LocalDateTime.now());
		
		Long id = productRepo.save(productEntity).getId();
		
		return id;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(product.getId());
		productEntity.setProductId(product.getProductId());
		productEntity.setProduct_name(product.getProduct_name());
		productEntity.setCategory(product.getCategory());
		productEntity.setGender(product.getGender());
		productEntity.setPrice(product.getPrice());
		productEntity.setDiscount(product.getDiscount());
		productEntity.setCreated_date(product.getCreated_date());
		productEntity.setUpdated_date(LocalDateTime.now());
		
		productRepo.save(productEntity);
		
		return product;
	}

	@Override
	public void deleteProduct(Long product_id) {
		
		productRepo.deleteById(product_id);
		
	}

	@Override
	public ProductDTO getProductDetails(Long product_id) {
		
		ProductEntity entity = findproduct(product_id);
		
		ProductDTO productdto = new ProductDTO();
		
		productdto.setId(entity.getId());
		productdto.setProductId(entity.getProductId());
		productdto.setProduct_name(entity.getProduct_name());
		productdto.setCategory(entity.getCategory());
		productdto.setGender(entity.getGender());
		productdto.setPrice(entity.getPrice());
		productdto.setDiscount(entity.getDiscount());
		productdto.setCreated_date(entity.getCreated_date());
		productdto.setUpdated_date(entity.getUpdated_date());
		
		return productdto;
	
	}
	
	private ProductEntity findproduct(Long product_id) {
		Optional<ProductEntity> entity = productRepo.findById(product_id);
		return entity.orElseThrow(() -> new ProductNotFoundException("Product Not Found!"));
		
	}

}
