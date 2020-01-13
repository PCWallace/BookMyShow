package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.SeatBookingStatus;
import com.epam.service.SeatBookingService;

@RestController
@RequestMapping(value = "/seatStatus")
public class SeatBookingStatausController {
	@Autowired
	private SeatBookingService seats;

	@RequestMapping(method = RequestMethod.POST, value = "/seats", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<SeatBookingStatus> insert(@RequestBody List<SeatBookingStatus> dto) {
		return seats.insert(dto);
	}

	@GetMapping(value = "/{showId}")
	public List<SeatBookingStatus> getStatus(@PathVariable String showId) {
		return seats.getSeatBookingStatus(showId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<SeatBookingStatus> updateStatus(@RequestBody List<SeatBookingStatus> dto) {
		return seats.update(dto);
	}

	@GetMapping(value = "/All")
	public List<SeatBookingStatus> getAll() {
		return seats.getAll();
	}
}
