package com.aviECom.ordermanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

	private String message;
	private String status;
}
