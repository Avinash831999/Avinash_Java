package com.aviECom.ordermanagement.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders_tbl")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private String orderUuid;
	private Long userId;
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderedDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime deliveredDate;
	
	private String modeOfDelivery;
	
	private double totalAmount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime expectedDeliveryDate;
	
	private String orderStatus;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,
	          CascadeType.MERGE
	    })
	@JoinTable(
			  name = "products_order_mapping", 
			  joinColumns = @JoinColumn(name = "order_id"), 
					  inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<ProductEntity> productsOrdered = new HashSet<>();
}
