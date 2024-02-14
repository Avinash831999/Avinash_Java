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
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	
	private String order_uuid;
	private Long user_id;
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ordered_date;
	
	private String mode_of_delivery;
	
	private double total_amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime expected_delivery_date;
	
	private String order_status;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,
	          CascadeType.MERGE
	    })
	@JoinTable(
			  name = "order_products_mapping", 
			  joinColumns = @JoinColumn(name = "order_id"), 
					  inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<ProductEntity> productsOrdered = new HashSet<>();
}
