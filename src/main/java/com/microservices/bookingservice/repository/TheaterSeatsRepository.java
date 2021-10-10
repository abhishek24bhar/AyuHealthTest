package com.microservices.bookingservice.repository;

import com.microservices.bookingservice.domain.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity, Long>, JpaSpecificationExecutor<TheaterSeatsEntity> {

}