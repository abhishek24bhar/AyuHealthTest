/**
 * 
 */
package com.microservices.bookingservice.service;


import com.microservices.bookingservice.dto.request.BookTicketRequestDto;
import com.microservices.bookingservice.dto.request.TicketDto;

public interface TicketService {

	TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

	TicketDto getTicket(long id);
}