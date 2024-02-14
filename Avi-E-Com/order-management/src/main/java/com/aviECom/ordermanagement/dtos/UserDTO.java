package com.aviECom.ordermanagement.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;

	private String userId;

	private String firstName;

	private String lastName;

	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updated_date;
	
	
}
