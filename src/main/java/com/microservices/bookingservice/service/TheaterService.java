/**
 * 
 */
package com.microservices.bookingservice.service;


import com.microservices.bookingservice.dto.request.TheaterDto;

public interface TheaterService {

	TheaterDto addTheater(TheaterDto theaterDto);

	TheaterDto getTheater(long id);
}