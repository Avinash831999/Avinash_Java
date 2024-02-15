package com.aviECom.productmanagement.dtos;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private String apiPath;
	private HttpStatus statusCode;
	private String message;
	private LocalDateTime errorTime;
	
}
