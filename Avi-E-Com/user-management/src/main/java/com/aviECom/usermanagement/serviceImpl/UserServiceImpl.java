package com.aviECom.usermanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.aviECom.usermanagement.Exception.UserNotFoundException;
import com.aviECom.usermanagement.dtos.UserDTO;
import com.aviECom.usermanagement.entity.UserEntity;
import com.aviECom.usermanagement.repositories.UserRepository;
import com.aviECom.usermanagement.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public Long addUser(UserDTO userdto) {
		
		UserEntity entity = new UserEntity();
		
		entity.setFirstName(userdto.getFirstName());
		entity.setLastName(userdto.getLastName());
		entity.setEmail(userdto.getEmail());
		entity.setCreated_date(LocalDateTime.now());
		entity.setUserId(UUID.randomUUID().toString());
		
		Long id = this.userRepository.save(entity).getId();
		
		return id;
	}

	@Override
	public UserDTO updateUser(UserDTO userdto) {
		
		UserEntity entity = new UserEntity();
		
		entity.setId(userdto.getId());
		entity.setFirstName(userdto.getFirstName());
		entity.setLastName(userdto.getLastName());
		entity.setEmail(userdto.getEmail());
		entity.setCreated_date(userdto.getCreated_date());
		entity.setUserId(userdto.getUserId());
		entity.setUpdated_date(LocalDateTime.now());
		
		this.userRepository.save(entity);
		
		return userdto;
	}

	@Override
	public void deleteUser(Long user_id) {
		this.userRepository.deleteById(user_id);
	}

	@Override
	public UserDTO getUserDetails(Long user_id) {
		UserEntity entity = findproduct(user_id);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(entity.getId());
		userDTO.setUserId(entity.getUserId());
		userDTO.setFirstName(entity.getFirstName());
		userDTO.setLastName(entity.getLastName());
		userDTO.setEmail(entity.getEmail());
		userDTO.setCreated_date(entity.getCreated_date());
		userDTO.setUpdated_date(entity.getUpdated_date());
		
		
		
		return userDTO;
	}
	
	private UserEntity findproduct(Long user_id) {
		Optional<UserEntity> entity = this.userRepository.findById(user_id);
		return entity.orElseThrow(() -> new UserNotFoundException("User Not Found!"));
		
	}

}
