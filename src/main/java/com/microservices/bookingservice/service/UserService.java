/**
 * 
 */
package com.microservices.bookingservice.service;


import com.microservices.bookingservice.dto.request.UserDto;

public interface UserService {

	UserDto addUser(UserDto userDto);

	UserDto getUser(long id);

	boolean deleteUser(String login);
}