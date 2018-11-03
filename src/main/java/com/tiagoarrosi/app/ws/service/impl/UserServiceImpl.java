package com.tiagoarrosi.app.ws.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrosi.app.ws.UserRepository;
import com.tiagoarrosi.app.ws.io.entity.UserEntity;
import com.tiagoarrosi.app.ws.service.UserService;
import com.tiagoarrosi.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());
		
		if (storedUserDetails != null) {
			throw new RuntimeException("Record already exists");
		}		
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setUserId("testUserId");
		userEntity.setEncryptedPassword("test");
		
		storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

}
