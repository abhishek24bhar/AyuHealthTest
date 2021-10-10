/**
 * 
 */
package com.microservices.bookingservice.service;


import com.microservices.bookingservice.dto.commonDTO.UserDTO;
import com.microservices.bookingservice.dto.request.UserDto;

public interface UserService {

	UserDTO addUser(UserDTO userDto);

	UserDTO getUser(long id);

	boolean deleteUser(String login);
}