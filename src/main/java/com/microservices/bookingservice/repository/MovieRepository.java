package com.microservices.bookingservice.repository;

import com.microservices.bookingservice.domain.MovieEntity;
import com.microservices.bookingservice.enums.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {

	boolean existsByNameAndLanguage(String name, MovieLanguage language);
}