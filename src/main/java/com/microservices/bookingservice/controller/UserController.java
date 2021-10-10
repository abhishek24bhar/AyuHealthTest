/**
 * 
 */
package com.microservices.bookingservice.controller;

import javax.validation.constraints.Min;

import com.microservices.bookingservice.dto.commonDTO.UserDTO;
import com.microservices.bookingservice.dto.request.UserDto;
import com.microservices.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("user/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("add")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {

		log.info("Received Request to add new user: " + userDto);

		return ResponseEntity.ok(userService.addUser(userDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") @Min(value = 1, message = "User Id Cannot be -ve") long id) {

		log.info("Received Request to get user: " + id);

		return ResponseEntity.ok(userService.getUser(id));
	}
}