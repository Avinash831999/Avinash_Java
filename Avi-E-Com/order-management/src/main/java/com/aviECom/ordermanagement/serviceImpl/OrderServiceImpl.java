package com.aviECom.ordermanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aviECom.ordermanagement.dtos.OrderRequestDto;
import com.aviECom.ordermanagement.dtos.OrderResponseDto;
import com.aviECom.ordermanagement.dtos.ProductDTO;
import com.aviECom.ordermanagement.dtos.ProductInOrderDTO;
import com.aviECom.ordermanagement.entity.OrderEntity;
import com.aviECom.ordermanagement.entity.ProductEntity;
import com.aviECom.ordermanagement.repositories.OrderRepository;
import com.aviECom.ordermanagement.repositories.ProductRepository;
import com.aviECom.ordermanagement.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepo;
	
	private final ProductRepository productRepo;
	
	public OrderServiceImpl(OrderRepository orderRepo, ProductRepository productRepo) {
		this.orderRepo=orderRepo;
		this.productRepo = productRepo;
	}
	
	@Override
	public OrderRequestDto placeOrder(OrderRequestDto orderReq) {
		
		OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setOrder_uuid(UUID.randomUUID().toString().replace("-", ""));
		orderEntity.setAddress(orderReq.getAddress());
		orderEntity.setMode_of_delivery(orderReq.getMode_of_delivery());
		orderEntity.setExpected_delivery_date(LocalDateTime.now().plusDays(5));
		orderEntity.setOrder_status("Ordered");
		orderEntity.setOrdered_date(LocalDateTime.now());
		orderEntity.setTotal_amount(0);
		//orderEntity.setProductsOrdered(products);
		orderEntity.setUser_id(orderReq.getUser_id());
		
		//Set<ProductEntity> products = new HashSet<>();
		
//		orderReq.getProducts().forEach(product -> {
//			products.add(getProductDetails(product.getId()));
//		});
		
		//double amount = 0;
		for( ProductInOrderDTO product: orderReq.getProducts()) {
			
			ProductDTO productInOrder = getProductDetails(product.getId());
			
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProduct_id(productInOrder.getProduct_id());
			productEntity.setProduct_uuid(productInOrder.getProduct_uuid());
			productEntity.setProduct_name(productInOrder.getProduct_name());
			productEntity.setCategory(productInOrder.getCategory());
			productEntity.setGender(productInOrder.getGender());
			productEntity.setPrice(productInOrder.getPrice());
			productEntity.setDiscount(productInOrder.getDiscount());
			
			
			
			orderEntity.getProductsOrdered().add(productEntity);
			//productEntity.getOrders().add(orderEntity);
			//products.add(productEntity);
			//productRepo.save(productEntity);
			
			//amount=amount+(productInOrder.getPrice()-(amount * (productInOrder.getDiscount()/100)))*product.getQuantity();
		}
			
		orderRepo.save(orderEntity);
		
		return null;
	}

	@Override
	public OrderResponseDto cancelOrder(Long orderId) {
		
		return null;
	}

	@Override
	public OrderResponseDto deliverOrder(Long orderId) {
		
		return null;
	}
	
	
	
	private ProductDTO getProductDetails(Long product_id) {
		
		String uri ="http://localhost:8010/api/product/get/"+product_id;
		RestTemplate rest = new RestTemplate();
		ProductDTO productDetails = rest.getForObject(uri, ProductDTO.class);
		return productDetails;
		
	}
	
	
}
