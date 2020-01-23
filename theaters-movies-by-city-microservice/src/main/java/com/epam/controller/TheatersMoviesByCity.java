package com.epam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.dto.MovieResponseDto;
import com.epam.dto.ScreenResponseDto;
import com.epam.dto.ShowResponseDto;
import com.epam.dto.TheaterResponseDto;
import com.epam.dto.TheatersMoviesDto;
import com.epam.response.MovieResponse;
import com.epam.response.ScreenListResponse;
import com.epam.response.ShowListResponse;
import com.epam.response.TheaterListResponse;
import com.epam.response.TheaterMovieByCityResponse;

@RestController
public class TheatersMoviesByCity {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TheaterMovieByCityResponse theaterMovieByCityResponse;

	@Autowired
	private TheatersMoviesDto theatersMoviesDto;

	@GetMapping(value = "/tmbc/{cityId}")
	public ResponseEntity<TheaterMovieByCityResponse> getTheatersMoviesByCity(@PathVariable String cityId) {

		ResponseEntity<TheaterListResponse> theaterResponse = restTemplate
				.getForEntity("http://theater-microservice/city/" + cityId, TheaterListResponse.class);
		ResponseEntity<ScreenListResponse> screenListResponse = null;
		for (TheaterResponseDto currentTheater : theaterResponse.getBody().getDetails()) {
			screenListResponse = restTemplate.getForEntity(
					"http://screen-microservice/theater/" + currentTheater.getTheaterId(), ScreenListResponse.class);
		}
		ResponseEntity<ShowListResponse> showsResponse = null;
		for (ScreenResponseDto currentScreen : screenListResponse.getBody().getDetails()) {
			showsResponse = restTemplate.getForEntity("http://shows-microservice/screen/" + currentScreen.getScreenId(),
					ShowListResponse.class);
		}

		List<MovieResponseDto> movies = new ArrayList<>();
		for (ShowResponseDto currentShow : showsResponse.getBody().getDetails()) {
			ResponseEntity<MovieResponse> movieResponse = restTemplate
					.getForEntity("http://movies-microservice/" + currentShow.getMovieId(), MovieResponse.class);
			movies.add(movieResponse.getBody().getDetails());
		}
		theatersMoviesDto.setMovies(movies);
		theatersMoviesDto.setTheaters(theaterResponse.getBody().getDetails());
		theaterMovieByCityResponse.setDetails(theatersMoviesDto);
		theaterMovieByCityResponse.setMessage("All the movies and the theaters of the city");
		theaterMovieByCityResponse.setStatus(HttpStatus.OK);
		return new ResponseEntity<>(theaterMovieByCityResponse, HttpStatus.OK);

	}
}
