package com.aviECom.usermanagement.controllers;

import org.springframework.http.ResponseEntity;

import com.aviECom.usermanagement.dtos.ResponseDTO;
import com.aviECom.usermanagement.dtos.UserDTO;

public interface UserController {
	public ResponseEntity<ResponseDTO> addUser(UserDTO userDTO);

	public ResponseEntity<UserDTO> getUserDetails(Long user_id);

	public ResponseEntity<ResponseDTO> updateUser(UserDTO userDTO);

	public ResponseEntity<ResponseDTO> deleteUser(Long user_id);
	
	//public ResonseEntity<>
}
