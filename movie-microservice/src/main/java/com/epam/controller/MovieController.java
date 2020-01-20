package com.epam.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.MovieRequestDto;
import com.epam.dto.MovieResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.ErrorResponse;
import com.epam.response.MovieListResponse;
import com.epam.response.MovieResponse;
import com.epam.service.MovieServices;

@RestController
public class MovieController {

	@Autowired
	private MovieServices movies;

	@Autowired
	private MovieListResponse movieListResponse;

	@Autowired
	private MovieResponse movieResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@GetMapping(value = "/{movieId}")
	public ResponseEntity<MovieResponse> getMovieById(@PathVariable String movieId) throws NoContentFoundException {
		MovieResponseDto movie;
		try {
			movie = movies.getMovieById(movieId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No movie with this Id");
		}
		movieResponse.setDetails(movie);
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("Movie was found");
		return new ResponseEntity<>(movieResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/All")
	public ResponseEntity<MovieListResponse> getAllMovies() throws NoContentFoundException {
		List<MovieResponseDto> moviesList = movies.getAll();
		if (moviesList.isEmpty()) {
			throw new NoContentFoundException("There are no movies in the database");
		}
		movieListResponse.setDetails(moviesList);
		movieListResponse.setStatus(HttpStatus.OK);
		movieListResponse.setMessage("All the movies in the database");
		return new ResponseEntity<>(movieListResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/movie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieResponse> register(@RequestBody MovieRequestDto dto) throws SQLException {
		MovieResponseDto movie;
		try {
			movie = movies.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		movieResponse.setDetails(movie);
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("Movie get registered");
		return new ResponseEntity<>(movieResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{movieId}")
	public ResponseEntity<ErrorResponse> delete(@PathVariable String movieId)
			throws NoContentFoundException, SQLException {
		MovieResponseDto movie;
		try {
			movie = movies.getMovieById(movieId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No movie with this Id");
		}
		try {
			movies.delete(movie.getMovieId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("City Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@PutMapping(value = "/{movieId}")
	public ResponseEntity<MovieResponse> updateMovie(@PathVariable String movieId, int status)
			throws NoContentFoundException, SQLException {
		MovieResponseDto movie;
		try {
			movie = movies.getMovieById(movieId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No movie with this Id");
		}
		movie.setActive(status);
		try {
			movie = movies.update(movie);
		} catch (SQLException e) {
			throw new SQLException("Number of screens of theater does not get updated");
		}
		movieResponse.setDetails(movie);
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("Movie get updated	");
		return new ResponseEntity<>(movieResponse, HttpStatus.OK);
	}
}
