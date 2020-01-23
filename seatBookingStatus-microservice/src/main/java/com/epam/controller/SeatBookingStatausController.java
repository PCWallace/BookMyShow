package com.epam.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.SeatBookingStatusRequestDto;
import com.epam.dto.SeatBookingStatusResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.SeatBookingStatusListResponse;
import com.epam.service.SeatBookingService;

@RestController

public class SeatBookingStatausController {
	@Autowired
	private SeatBookingService seats;

	@Autowired
	private SeatBookingStatusListResponse seatBookingStatusListResponse;

	@PostMapping(value = "/seats", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeatBookingStatusListResponse> insert(@RequestBody List<SeatBookingStatusRequestDto> dto)
			throws SQLException {
		List<SeatBookingStatusResponseDto> seatBookingStatusDtoList;
		try {
			seatBookingStatusDtoList = seats.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		seatBookingStatusListResponse.setDetails(seatBookingStatusDtoList);
		seatBookingStatusListResponse.setStatus(HttpStatus.OK);
		seatBookingStatusListResponse.setMessage("SeatBooking status status get updated");
		return new ResponseEntity<>(seatBookingStatusListResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/{showId}")
	public ResponseEntity<SeatBookingStatusListResponse> getStatus(@PathVariable String showId)
			throws NoContentFoundException {
		List<SeatBookingStatusResponseDto> seatBookingStatusDtoList = seats.getSeatBookingStatus(showId);
		if (seatBookingStatusDtoList.isEmpty()) {
			throw new NoContentFoundException("There are no seats booking available for this show");
		}
		seatBookingStatusListResponse.setDetails(seatBookingStatusDtoList);
		seatBookingStatusListResponse.setStatus(HttpStatus.OK);
		seatBookingStatusListResponse.setMessage("All the seats status of this show");
		return new ResponseEntity<>(seatBookingStatusListResponse, HttpStatus.OK);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeatBookingStatusListResponse> updateStatus(
			@RequestBody List<SeatBookingStatusResponseDto> dto) throws NoContentFoundException, SQLException {
		List<SeatBookingStatusResponseDto> seatBookingStatusDtoList = new ArrayList<>();
		for (SeatBookingStatusResponseDto currentSeat : dto) {
			SeatBookingStatusResponseDto seat;
			try {
				seat = seats.getSeatBookingStatusBySeatBookingStatusId(currentSeat.getSeatBookingStatusId());
			} catch (SQLException e) {
				throw new NoContentFoundException("No seat with this Id");
			}
			seatBookingStatusDtoList.add(seat);
		}
		try {
			seatBookingStatusDtoList = seats.update(seatBookingStatusDtoList);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		seatBookingStatusListResponse.setDetails(seatBookingStatusDtoList);
		seatBookingStatusListResponse.setStatus(HttpStatus.OK);
		seatBookingStatusListResponse.setMessage("SeatBooking status status get updated");
		return new ResponseEntity<>(seatBookingStatusListResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/All")
	public ResponseEntity<SeatBookingStatusListResponse> getAll() throws NoContentFoundException {
		List<SeatBookingStatusResponseDto> seatBookingStatusDtoList = seats.getAll();
		if (seatBookingStatusDtoList.isEmpty()) {
			throw new NoContentFoundException("There are no seats booking available in the database");
		}
		seatBookingStatusListResponse.setDetails(seatBookingStatusDtoList);
		seatBookingStatusListResponse.setStatus(HttpStatus.OK);
		seatBookingStatusListResponse.setMessage("All the cities in the database");
		return new ResponseEntity<>(seatBookingStatusListResponse, HttpStatus.OK);
	}
}
