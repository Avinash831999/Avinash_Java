package com.aviECom.usermanagement.dtos;

import java.time.LocalDateTime;
import java.util.Set;

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
	private LocalDateTime createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedDate;
	
	private Set<UserOrderDetails> orders;
}
