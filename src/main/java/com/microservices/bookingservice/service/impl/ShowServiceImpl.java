/**
 * 
 */
package com.microservices.bookingservice.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.microservices.bookingservice.adapter.ShowAdapter;
import com.microservices.bookingservice.adapter.ShowSeatsAdapter;
import com.microservices.bookingservice.domain.*;
import com.microservices.bookingservice.dto.request.ShowDto;
import com.microservices.bookingservice.dto.request.ShowSeatsDto;
import com.microservices.bookingservice.dto.response.PageResponse;
import com.microservices.bookingservice.exception.DependencyException;
import com.microservices.bookingservice.helper.ShowHelper;
import com.microservices.bookingservice.repository.MovieRepository;
import com.microservices.bookingservice.repository.ShowRepository;
import com.microservices.bookingservice.repository.ShowSeatsRepository;
import com.microservices.bookingservice.repository.TheaterRepository;
import com.microservices.bookingservice.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository showsRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowSeatsRepository showSeatsRepository;

	@Override
	public ShowDto addShow(ShowDto showDto) {

		Optional<MovieEntity> optionalMovie = movieRepository.findById(showDto.getMovie().getId());

		if (!optionalMovie.isPresent()) {
			throw new DependencyException("Movie Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		Optional<TheaterEntity> optionalTheater = theaterRepository.findById(showDto.getTheatre().getId());

		if (!optionalTheater.isPresent()) {
			throw new DependencyException("Theater Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		log.info("Adding New Show: " + showDto);

		ShowEntity showEntity = ShowAdapter.toEntity(showDto);

		showEntity.setMovie(optionalMovie.get());
		showEntity.setTheater(optionalTheater.get());
		showEntity.setSeats(generateShowSeats(showEntity.getTheater().getSeats(), showEntity));

		for (ShowSeatsEntity seatsEntity : showEntity.getSeats()) {
			seatsEntity.setShow(showEntity);
		}

		showEntity = showsRepository.save(showEntity);

		log.info("Successfully Added New Show [ID: " + showEntity.getId() + ", ShowDate: " + showEntity.getShowDate() + ", ShowTime: " + showEntity.getShowTime() + "]");

		return ShowAdapter.toDto(showEntity);
	}

	private List<ShowSeatsEntity> generateShowSeats(List<TheaterSeatsEntity> theaterSeatsEntities, ShowEntity showEntity) {

		List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();

		for (TheaterSeatsEntity theaterSeatsEntity : theaterSeatsEntities) {

			ShowSeatsEntity showSeatsEntity =
					ShowSeatsEntity.builder()
							.seatNumber(theaterSeatsEntity.getSeatNumber())
							.seatType(theaterSeatsEntity.getSeatType())
							.rate((int) (theaterSeatsEntity.getRate() * showEntity.getRateMultiplier()))
							.build();

			showSeatsEntities.add(showSeatsEntity);
		}

		return showSeatsRepository.saveAll(showSeatsEntities);
	}

	@Override
	public PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit) {

		log.info("Searching Shows by Params: [showName: " + movieName + ", city: " + city + ", showDate: " + showDate + ", showTime: " + showTime + "]");

		Specification<ShowEntity> specifications = ShowHelper.createSpecification(movieName, city, showDate, showTime);

		Page<ShowEntity> showsPage = showsRepository.findAll(specifications, PageRequest.of(pageNo - 1, limit));

		log.info("Found " + showsPage.getNumberOfElements() + " Shows on Page: " + showsPage.getNumber());

		PageResponse<ShowDto> pageResponse = new PageResponse<>();

		if (showsPage.hasContent()) {
			pageResponse.setNumber(pageNo);
			pageResponse.setRecords(showsPage.getNumberOfElements());

			pageResponse.setTotalPages(showsPage.getTotalPages());
			pageResponse.setTotalRecords(showsPage.getTotalElements());

			pageResponse.setData(ShowAdapter.toDto(showsPage.getContent()));
		}

		return pageResponse;
	}

	@Override
	public List<ShowSeatsDto> getAvailableSeatsByShows(Long showId) {

		log.info("Fetching ShowSeats by Show: [showId: " + showId +"]");

		Optional<ShowEntity> optionalShow = showsRepository.findById(showId);
		if (!optionalShow.isPresent()) {
			throw new DependencyException("Show Not Found with ID: " + showId);
		}
		List<ShowSeatsEntity> showSeatsEntities = optionalShow.get().getSeats();

		showSeatsEntities = showSeatsEntities.stream().filter(seat -> !seat.isBooked())
				.collect(Collectors.toList());
		if (showSeatsEntities.size() == 0) {
			throw new DependencyException("Seats Not Available");
		}

		log.info("Found NumberOfElements" + " Shows on Page: " + showSeatsEntities.size());

		return ShowSeatsAdapter.toDto(showSeatsEntities);
	}

}