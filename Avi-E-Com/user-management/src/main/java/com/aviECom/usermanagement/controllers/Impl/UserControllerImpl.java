package com.aviECom.usermanagement.controllers.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviECom.usermanagement.constants.UserManagementConstants;
import com.aviECom.usermanagement.controllers.UserController;
import com.aviECom.usermanagement.dtos.ResponseDTO;
import com.aviECom.usermanagement.dtos.UserDTO;
import com.aviECom.usermanagement.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserControllerImpl implements UserController{

	private final UserService userServive;
	
	public UserControllerImpl(UserService userServive) {
		this.userServive=userServive;
	}
	
	@PostMapping("/add")
	@Override
	public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
		this.userServive.addUser(userDTO);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDTO("User Successfully created!", UserManagementConstants.userCreated));
	}

	@GetMapping("/get/{user_id}")
	@Override
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long user_id) {
		UserDTO userDto = this.userServive.getUserDetails(user_id); 
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(userDto);
	}

	@PostMapping("/update")
	@Override
	public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO) {
		//UserDTO userDto =
				this.userServive.updateUser(userDTO);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDTO("User Successfully Updated!", UserManagementConstants.userUpdated));
	}

	@DeleteMapping("/delete/{user_id}")
	@Override
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long user_id) {
		this.userServive.deleteUser(user_id);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDTO("User deleted!", UserManagementConstants.userDeleted));
	}

}
