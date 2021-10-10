/**
 * 
 */
package com.microservices.bookingservice.service;


import com.microservices.bookingservice.dto.request.MovieDto;

public interface MovieService {

	MovieDto addMovie(MovieDto movieDto);

	MovieDto getMovie(long id);
}