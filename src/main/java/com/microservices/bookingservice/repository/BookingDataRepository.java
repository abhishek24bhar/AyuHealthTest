package com.microservices.bookingservice.repository;/* ehbabah created on 10/1/2021  */

import com.microservices.bookingservice.dto.commonDTO.CinemaHallSeat;
import com.microservices.bookingservice.dto.commonDTO.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDataRepository extends JpaRepository<Movie, Long> {
    @Query("from movies WHERE city=:city")
    List<Movie> getMoviesByCity(@Param(value = "city") String city);


    @Query("FROM theater_seats where theatre_id=:theatre_id")
    List<CinemaHallSeat> getTheatreSeatById(@Param(value = "theatre_id") Long theatre_id);

}
