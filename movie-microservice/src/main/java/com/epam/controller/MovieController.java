package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Movie;
import com.epam.service.MovieServices;

@RestController
public class MovieController {

	@Autowired
	private MovieServices movies;

	@GetMapping(value = "/{movieId}")
	public Movie getMovieById(@PathVariable String movieId) {
		return movies.getMovieById(movieId);
	}

	@GetMapping(value = "/All")
	public List<Movie> getAllMovies() {
		return movies.getAll();
	}

	@PostMapping(value = "/movie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie register(@RequestBody Movie dto) {
		return movies.insert(dto);
	}

	@DeleteMapping(value = "/{movieId}")
	public Movie delete(@PathVariable String movieId) {
		return movies.delete(movieId);
	}

	@PutMapping(value = "/{movieId}")
	public Movie updateMovie(@PathVariable String movieId) {
		return movies.update(movieId);
	}
}
