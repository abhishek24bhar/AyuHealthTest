package com.microservices.bookingservice.repository;

import com.microservices.bookingservice.domain.ShowEntity;
import com.microservices.bookingservice.domain.ShowSeatsEntity;
import com.microservices.bookingservice.dto.commonDTO.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Long>, JpaSpecificationExecutor<ShowSeatsEntity> {

    @Query("from ShowSeatsEntity s where isBooked=false and showId=:showId")
    List<ShowSeatsEntity> getAvailableSeatsByShows(@Param(value = "showId") String showId);

}