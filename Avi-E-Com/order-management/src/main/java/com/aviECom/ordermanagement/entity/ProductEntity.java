package com.aviECom.ordermanagement.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_in_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	
	private String product_uuid;
	
	private String product_name;
	
	private String category;
	
	private String gender;
	
	private float price;
	
	private float discount;
	
	@ManyToMany(mappedBy = "productsOrdered", cascade = {CascadeType.PERSIST,
	          CascadeType.MERGE},fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<OrderEntity> orders = new HashSet<>();
}
