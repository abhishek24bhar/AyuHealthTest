package com.microservices.bookingservice.dto.commonDTO;/*
Abhishek Bhargava created on 10/1/2021  
*/


import com.microservices.bookingservice.enums.SeatType;

public class CinemaHallSeat extends CinemaHall {
    int seatRow;
    int seatColumn;
    SeatType seatType;
}
