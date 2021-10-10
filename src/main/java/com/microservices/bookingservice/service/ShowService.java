/**
 * 
 */
package com.microservices.bookingservice.service;

import com.microservices.bookingservice.domain.ShowEntity;
import com.microservices.bookingservice.domain.ShowSeatsEntity;
import com.microservices.bookingservice.dto.commonDTO.ShowSeat;
import com.microservices.bookingservice.dto.request.ShowDto;
import com.microservices.bookingservice.dto.request.ShowSeatsDto;
import com.microservices.bookingservice.dto.response.PageResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ShowService {

	ShowDto addShow(ShowDto showDto);

	PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit);

	List<ShowSeatsDto> getAvailableSeatsByShows(Long showId);

}