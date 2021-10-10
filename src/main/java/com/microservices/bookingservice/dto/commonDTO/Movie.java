package com.microservices.bookingservice.dto.commonDTO;/*
Abhishek Bhargava created on 10/1/2021  
*/

import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private int durationInMins;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    //private Admin movieAddedBy;

    private List<Show> shows;

    /**
     * List down all shows for the movie.
     * */
    public List<Show> getShows(){
        return null;
    }
}
