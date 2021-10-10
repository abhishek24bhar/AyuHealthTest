/**
 * 
 */
package com.microservices.bookingservice.adapter;


import com.microservices.bookingservice.dto.request.UserDto;
import com.microservices.bookingservice.domain.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserAdapter {

	public static UserEntity toEntity(UserDto userDto) {

		return UserEntity.builder()
				.name(userDto.getName())
				.mobile(userDto.getMobile())
				.build();

	}

	public static UserDto toDto(UserEntity userEntity) {

		return UserDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.mobile(userEntity.getMobile())
				.build();
	}

}