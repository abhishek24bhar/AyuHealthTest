package com.microservices.bookingservice.dto.commonDTO;/*
Abhishek Bhargava created on 10/1/2021  
*/

import java.util.List;

public class CinemaHall {
    private String name;
    private int totalSeats;

    private List<CinemaHallSeat> seats;
    private List<Show> shows;

}
