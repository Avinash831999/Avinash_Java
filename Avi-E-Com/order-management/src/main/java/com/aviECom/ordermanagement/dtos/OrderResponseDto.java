package com.aviECom.ordermanagement.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
	private long order_id;
	private String order_uuid;
	private String user_id;
	private String address;
	private LocalDateTime ordered_date;

	private String mode_of_delivery;

	private double total_amount;
	private LocalDateTime expected_delivery_date;

	private String order_status;
	//Set<ProductDTO> productsOrdered;
}
