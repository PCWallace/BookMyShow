package com.epam.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.SeatRequestDto;
import com.epam.dto.SeatResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.ErrorResponse;
import com.epam.response.SeatListResponse;
import com.epam.service.SeatServices;

@RestController
@RequestMapping(value = "/seats")
public class SeatController {

	@Autowired
	private SeatServices seats;

	@Autowired
	private SeatListResponse seatListResponse;

	@Autowired
	private ErrorResponse errorResponse;
	
	@GetMapping(value = "/All")
	public ResponseEntity<SeatListResponse> getAlSeats()
			throws NoContentFoundException {
		List<SeatResponseDto> seatsList = seats.getAllSeats();
		if (seatsList.isEmpty()) {
			throw new NoContentFoundException("There are no seats in the database for this screen");
		}
		seatListResponse.setDetails(seatsList);
		seatListResponse.setStatus(HttpStatus.OK);
		seatListResponse.setMessage("All the seats in the screen");
		return new ResponseEntity<>(seatListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{screenId}")
	public ResponseEntity<SeatListResponse> getAlSeatsBySreen(@PathVariable String screenId)
			throws NoContentFoundException {
		List<SeatResponseDto> seatsList = seats.getSeatByScreen(screenId);
		if (seatsList.isEmpty()) {
			throw new NoContentFoundException("There are no seats in the database for this screen");
		}
		seatListResponse.setDetails(seatsList);
		seatListResponse.setStatus(HttpStatus.OK);
		seatListResponse.setMessage("All the seats in the screen");
		return new ResponseEntity<>(seatListResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/seat")
	public ResponseEntity<SeatListResponse> inserttheSeats(@RequestBody List<SeatRequestDto> dto) throws SQLException {
		List<SeatResponseDto> seatsList;
		try {
			seatsList = seats.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		seatListResponse.setDetails(seatsList);
		seatListResponse.setStatus(HttpStatus.OK);
		seatListResponse.setMessage("City get registered");
		return new ResponseEntity<>(seatListResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{screenId}")
	public ResponseEntity<ErrorResponse> deleteSeat(@PathVariable String screenId)
			throws NoContentFoundException, SQLException {
		List<SeatResponseDto> seatsList = seats.getSeatByScreen(screenId);
		if (seatsList.isEmpty()) {
			throw new NoContentFoundException("There are no seats in the database for this screen");
		}
		try {
			seats.delteByScreenId(seatsList);
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("All seats Deleted Successfully of the screen");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
