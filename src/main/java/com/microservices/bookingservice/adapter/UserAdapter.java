/**
 * 
 */
package com.microservices.bookingservice.adapter;


import com.microservices.bookingservice.dto.commonDTO.UserDTO;
import com.microservices.bookingservice.dto.request.UserDto;
import com.microservices.bookingservice.domain.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserAdapter {

	public static UserEntity toEntity(UserDTO userDto) {

		return UserEntity.builder()
				.firstName(userDto.getFirstName())
				.mobile(userDto.getMobile())
				.build();

	}

	public static UserDTO toDto(UserEntity userEntity) {

		return UserDTO.builder()
				.id(userEntity.getId())
				.firstName(userEntity.getFirstName())
				.mobile(userEntity.getMobile())
				.build();
	}

}