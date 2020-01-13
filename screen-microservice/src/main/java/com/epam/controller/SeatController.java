package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Seat;
import com.epam.service.SeatServices;

@RestController
@RequestMapping(value = "/seats")
public class SeatController {

	@Autowired
	private SeatServices seats;

	@GetMapping(value = "/{screenId}")
	public List<Seat> getAlSeatsBySreen(@PathVariable String screenId) {
		return seats.getSeatByScreen(screenId);
	}

	@PostMapping(value = "/seat")
	public List<Seat> inserttheSeats(@RequestBody List<Seat> dto) {
		return seats.insert(dto);
	}

	@DeleteMapping(value = "/{screenId}")
	public boolean deleteSeat(@PathVariable String screenId) {
		return seats.delteByScreenId(screenId);
	}
}
