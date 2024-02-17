package com.aviECom.ordermanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
	
	public OrderServiceImpl(OrderRepository orderRepo,ProductRepository productRepo) {
		this.orderRepo=orderRepo;
		this.productRepo=productRepo;
	}
	
	@Override
	public OrderRequestDto placeOrder(OrderRequestDto orderReq) {
		
		OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setOrderUuid(UUID.randomUUID().toString().replace("-", ""));
		orderEntity.setAddress(orderReq.getAddress());
		orderEntity.setModeOfDelivery(orderReq.getModeOfDelivery());
		orderEntity.setExpectedDeliveryDate(LocalDateTime.now().plusDays(5));
		orderEntity.setOrderStatus("Ordered");
		orderEntity.setOrderedDate(LocalDateTime.now());
		orderEntity.setTotalAmount(0);
		//orderEntity.setProductsOrdered(products);
		orderEntity.setUserId(orderReq.getUserId());
		
		//Set<ProductEntity> products = new HashSet<>();
		
//		orderReq.getProducts().forEach(product -> {
//			products.add(getProductDetails(product.getId()));
//		});
		
		//double amount = 0;
		for( ProductInOrderDTO product: orderReq.getProducts()) {
			
			ProductDTO productInOrder = getProductDetails(product.getId());
			
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(productInOrder.getProductId());
			productEntity.setProductUuid(productInOrder.getProductUuid());
			productEntity.setProductName(productInOrder.getProductName());
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

	@Override
	public List<OrderResponseDto> getUsersOrder(long user_id) {
		
		List<OrderEntity> ordersByUser = orderRepo.findByUserId(user_id);
		
		List<OrderResponseDto> ordersDtoByUser = new ArrayList<>(); 
		
		ordersByUser.forEach(order -> {
			OrderResponseDto orderResponseDto = 
					new OrderResponseDto(order.getOrderId(), order.getOrderUuid(),
							order.getUserId(), order.getAddress(), order.getOrderedDate(),
							order.getModeOfDelivery(), order.getTotalAmount(), order.getExpectedDeliveryDate(),
							order.getDeliveredDate(), order.getOrderStatus(), getProductsDtoList(productRepo.productInOrder(order.getOrderId())));
			
			ordersDtoByUser.add(orderResponseDto);
			
		});
		
		
		return ordersDtoByUser;
	}

	private Set<ProductDTO> getProductsDtoList(List<ProductEntity> list) {
		Set<ProductDTO> productsDtoList = new HashSet<>();
		
		
		
		list.forEach(product -> {
			
			ProductDTO productDto = new ProductDTO
					(product.getProductId(), product.getProductUuid(), 
							product.getProductName(), product.getCategory(),
							product.getGender(), product.getPrice(), product.getDiscount());
			productsDtoList.add(productDto);
		});
		
		return productsDtoList;
	}
	
	
}
