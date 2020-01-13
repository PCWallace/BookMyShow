package com.epam.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.model.Movie;
import com.epam.model.Screen;
import com.epam.model.Shows;
import com.epam.model.TheatersList;
import com.epam.model.TheatersMovies;

@RestController
public class TheatersMoviesByCity {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/tmbc/{cityId}")
	public ResponseEntity<TheatersMovies> getTheatersMoviesByCity(@RequestParam String cityId) {

		TheatersList theaterList = restTemplate.getForObject("theaters/" + cityId, TheatersList.class);
		List<Movie> movies = theaterList.getTheaters().stream()
				.map(theater -> restTemplate.getForObject("screens/" + theater.getTheaterId(), Screen.class))
				.collect(Collectors.toList()).stream()
				.map(screen -> restTemplate.getForObject("shows/" + screen.getScreenId(), Shows.class))
				.collect(Collectors.toList()).stream()
				.map(shows -> restTemplate.getForObject("movies/" + shows.getMovieId(), Movie.class))
				.collect(Collectors.toList());
		TheatersMovies th = new TheatersMovies();
		th.setMovies(movies);
		th.setTheaters(theaterList.getTheaters());
		return ResponseEntity.ok(th);
	}
}
