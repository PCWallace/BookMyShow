package com.epam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.dto.MovieResponseDto;
import com.epam.dto.ScreenResponseDto;
import com.epam.dto.ShowResponseDto;
import com.epam.dto.TheaterViewRequestDto;
import com.epam.dto.TheaterViewResponseDto;
import com.epam.response.MovieResponse;
import com.epam.response.ScreenListResponse;
import com.epam.response.ShowListResponse;
import com.epam.response.TheaterViewResponse;

@RestController
public class TheaterViewController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TheaterViewResponse theaterViewResponse;

	@Autowired
	private TheaterViewResponseDto theaterViewResponseDto;

	@GetMapping(value = "/view")
	public ResponseEntity<TheaterViewResponse> getTheTheaterView(
			@RequestBody TheaterViewRequestDto theaterViewRequest) {
		ResponseEntity<ScreenListResponse> screenListResponse = restTemplate.getForEntity(
				"http://screen-microservice/theater/" + theaterViewRequest.getTheaterId(), ScreenListResponse.class);
		List<ShowResponseDto> showsList = new ArrayList<>();
		for (ScreenResponseDto currentScreen : screenListResponse.getBody().getDetails()) {
			ResponseEntity<ShowListResponse> showResponse = restTemplate
					.getForEntity("http://shows-microservice/showsbydatescreen/" + currentScreen.getScreenId() + "/"
							+ theaterViewRequest.getDateId(), ShowListResponse.class);
			showsList.addAll(showResponse.getBody().getDetails());
		}
		setShowsByMovie(showsList);
		theaterViewResponse.setDetails(theaterViewResponseDto);
		theaterViewResponse.setMessage("Theater view is");
		theaterViewResponse.setStatus(HttpStatus.OK);
		return new ResponseEntity<>(theaterViewResponse, HttpStatus.OK);

	}

	public void setShowsByMovie(List<ShowResponseDto> showsList) {
		Set<String> uniqueMoviesInTheater = new HashSet<>();
		Map<String, List<ShowResponseDto>> theaterView = new HashMap<>();
		Map<String, MovieResponseDto> movieMap = new HashMap<>();
		for (ShowResponseDto currentShow : showsList) {
			if (theaterView.containsKey(currentShow.getMovieId())) {
				List<ShowResponseDto> show = theaterView.get(currentShow.getMovieId());
				show.add(currentShow);
				theaterView.put(currentShow.getMovieId(), show);
			} else {
				uniqueMoviesInTheater.add(currentShow.getMovieId());
				ResponseEntity<MovieResponse> movieResponse = restTemplate
						.getForEntity("http://movies-microservice/" + currentShow.getMovieId(), MovieResponse.class);
				movieMap.put(currentShow.getMovieId(), movieResponse.getBody().getDetails());
				List<ShowResponseDto> show = new ArrayList<>();
				show.add(currentShow);
				theaterView.put(currentShow.getMovieId(), show);
			}
		}

		Map<MovieResponseDto, List<ShowResponseDto>> finalView = new HashMap<>();
		for (String movieId : uniqueMoviesInTheater) {
			finalView.put(movieMap.get(movieId), theaterView.get(movieId));
		}
		theaterViewResponseDto.setTheaterViewMap(finalView);
	}

}
