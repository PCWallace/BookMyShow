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

import com.epam.dto.TheaterRequestDto;
import com.epam.dto.TheaterResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.ErrorResponse;
import com.epam.response.TheaterListResponse;
import com.epam.response.TheaterResponse;
import com.epam.service.TheaterServices;

@RestController
public class TheaterController {

	@Autowired
	private TheaterServices theaters;

	@Autowired
	private TheaterListResponse theaterListResponse;

	@Autowired
	private TheaterResponse theaterResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@GetMapping(value = "/All")
	public ResponseEntity<TheaterListResponse> getAllMovies() throws NoContentFoundException {
		List<TheaterResponseDto> theatersList = theaters.getAll();
		if (theatersList.isEmpty()) {
			throw new NoContentFoundException("There are no Theaters in the database");
		}
		theaterListResponse.setDetails(theatersList);
		theaterListResponse.setStatus(HttpStatus.OK);
		theaterListResponse.setMessage("All the Theaters in the database");
		return new ResponseEntity<>(theaterListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{theaterId}")
	public ResponseEntity<TheaterResponse> getMovieById(@PathVariable String theaterId)
			throws SQLException, NoContentFoundException {
		TheaterResponseDto theater;
		try {
			theater = theaters.getTheaterById(theaterId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No theater with this Id");
		}
		theaterResponse.setDetails(theater);
		theaterResponse.setStatus(HttpStatus.OK);
		theaterResponse.setMessage("Theater was found");
		return new ResponseEntity<>(theaterResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/theater", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TheaterResponse> register(@RequestBody TheaterRequestDto dto) throws SQLException {
		TheaterResponseDto theater;
		try {
			theater = theaters.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		theaterResponse.setDetails(theater);
		theaterResponse.setStatus(HttpStatus.OK);
		theaterResponse.setMessage("Theater get registered");
		return new ResponseEntity<>(theaterResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{theaterId}")
	public ResponseEntity<ErrorResponse> delete(@PathVariable String theaterId)
			throws NoContentFoundException, SQLException {
		TheaterResponseDto theater;
		try {
			theater = theaters.getTheaterById(theaterId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No theater with this Id");
		}
		try {
			theaters.delete(theater.getTheaterId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("Theater Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@PutMapping(value = "theater/{theaterId}/{status}")
	public ResponseEntity<TheaterResponse> updateStatus(@PathVariable String theaterId, int status)
			throws NoContentFoundException, SQLException {
		TheaterResponseDto theater;
		try {
			theater = theaters.getTheaterById(theaterId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No theater with this Id");
		}
		theater.setActive(status);
		try {
			theater = theaters.updateTheaterStatus(theater);
		} catch (SQLException e) {
			throw new SQLException("Status of theater does not get updated");
		}
		theaterResponse.setDetails(theater);
		theaterResponse.setStatus(HttpStatus.OK);
		theaterResponse.setMessage("Theater status get updated");
		return new ResponseEntity<>(theaterResponse, HttpStatus.OK);
	}

	@PutMapping(value = "screen/{theaterId}/{screens}")
	public ResponseEntity<TheaterResponse> updateScreen(@PathVariable String theaterId, int screen)
			throws NoContentFoundException, SQLException {
		TheaterResponseDto theater;
		try {
			theater = theaters.getTheaterById(theaterId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No theater with this Id");
		}
		theater.setNumberOfScreens(theater.getNumberOfScreens() + screen);
		try {
			theater = theaters.updateNumberOfScreens(theater);
		} catch (SQLException e) {
			throw new SQLException("Number of screens of theater does not get updated");
		}
		theaterResponse.setDetails(theater);
		theaterResponse.setStatus(HttpStatus.OK);
		theaterResponse.setMessage("Theater screens get updated");
		return new ResponseEntity<>(theaterResponse, HttpStatus.OK);

	}

}
