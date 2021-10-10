/**
 * 
 */
package com.microservices.bookingservice.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.microservices.bookingservice.adapter.UserAdapter;
import com.microservices.bookingservice.dto.request.UserDto;
import com.microservices.bookingservice.exception.DuplicateRecordException;
import com.microservices.bookingservice.repository.UserRepository;
import com.microservices.bookingservice.service.UserService;
import com.microservices.bookingservice.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {

		if (userRepository.existsByMobile(userDto.getMobile())) {
			throw new DuplicateRecordException("User Already Exists with Mobile: " + userDto.getMobile());
		}

		log.info("Adding New User: " + userDto);

		UserEntity userEntity = UserAdapter.toEntity(userDto);

		userEntity = userRepository.save(userEntity);

		log.info("Added New User [id: " + userEntity.getId() + ", Mobile: " + userEntity.getMobile() + "]");

		return UserAdapter.toDto(userEntity);
	}

	@Override
	public UserDto getUser(long id) {

		log.info("Searching User by id: " + id);

		Optional<UserEntity> userEntity = userRepository.findById(id);

		if (!userEntity.isPresent()) {
			log.error("User not found for id: " + id);
			throw new EntityNotFoundException("User Not Found with ID: " + id);
		}

		return UserAdapter.toDto(userEntity.get());
	}

	@Override
	public boolean deleteUser(String login) {
		return false;
	}

}