package com.microservices.bookingservice.repository;

import com.microservices.bookingservice.domain.ShowEntity;
import com.microservices.bookingservice.domain.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long>, JpaSpecificationExecutor<ShowEntity> {

    @Query("from ShowEntity where showId=:showId")
    List<ShowSeatsEntity> getShowSeatsByShowId(@Param(value = "showId") int showId);

    //Inner Join matching data - from t1(parent) INNER JOIN t2 LIMIT 20 t1.id>0 between t2.id<20

}