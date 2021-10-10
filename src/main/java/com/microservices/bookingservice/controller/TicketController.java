/**
 * 
 */
package com.microservices.bookingservice.controller;

import javax.validation.constraints.Min;

import com.microservices.bookingservice.dto.request.BookTicketRequestDto;
import com.microservices.bookingservice.dto.request.TicketDto;
import com.microservices.bookingservice.exception.BookingNotDoneException;
import com.microservices.bookingservice.service.TicketService;
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
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/book")
	public ResponseEntity<TicketDto> bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {

		log.info("Received Request to book ticket: " + bookTicketRequestDto);
		TicketDto ticketDto = ticketService.bookTicket(bookTicketRequestDto);
		if (ticketDto != null)
		return ResponseEntity.ok(ticketDto);
		else throw new BookingNotDoneException();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TicketDto> getTicket(@PathVariable(name = "id") @Min(value = 1, message = "Ticket Id Cannot be -ve") long id) {

		log.info("Received Request to get ticket: " + id);

		return ResponseEntity.ok(ticketService.getTicket(id));
	}
}