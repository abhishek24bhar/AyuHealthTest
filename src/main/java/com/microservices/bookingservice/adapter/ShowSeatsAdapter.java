/**
 * 
 */
package com.microservices.bookingservice.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.microservices.bookingservice.domain.ShowSeatsEntity;
import com.microservices.bookingservice.dto.request.ShowSeatsDto;
import org.apache.commons.collections4.CollectionUtils;


import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowSeatsAdapter {

	public static List<ShowSeatsDto> toDto(List<ShowSeatsEntity> seatsEntities) {
		//Return all the seats of the Show
		if (CollectionUtils.isNotEmpty(seatsEntities)) {
			return seatsEntities.stream().map(ShowSeatsAdapter::toDto).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	public static ShowSeatsDto toDto(ShowSeatsEntity seatsEntity) {

		return ShowSeatsDto.builder()
				.id(seatsEntity.getId())
				.seatNumber(seatsEntity.getSeatNumber())
				.rate(seatsEntity.getRate())
				.seatType(seatsEntity.getSeatType())
				.booked(seatsEntity.isBooked())
				.bookedAt(seatsEntity.getBookedAt())
				.build();

	}

}