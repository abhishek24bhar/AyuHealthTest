package com.microservices.bookingservice.dto.commonDTO;/*
Abhishek Bhargava created on 10/1/2021  
*/

import java.util.Date;

public class Show {
    private int showId;
    private Date createdOn;
    private Date startTime;
    private Date endTime;
    private CinemaHall playedAt;
    private Movie movie;
}
