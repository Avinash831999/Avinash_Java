package com.aviECom.usermanagement.services;

import com.aviECom.usermanagement.dtos.UserDTO;

public interface UserService {
public Long addUser(UserDTO userdto);
	
	public UserDTO updateUser(UserDTO product);
	
	public void deleteUser(Long user_id);
	
	public UserDTO getUserDetails(Long user_id);
}
