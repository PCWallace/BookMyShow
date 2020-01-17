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

import com.epam.entity.Theater;
import com.epam.service.TheaterServices;

@RestController
public class TheaterController {

	@Autowired
	private TheaterServices theaters;

	@GetMapping(value = "/All")
	public List<Theater> getAllMovies() {
		return theaters.getAll();
	}

	@GetMapping(value = "/{theaterId}")
	public Theater getMovieById(@PathVariable String theaterId) {
		return theaters.getTheaterById(theaterId);
	}

	@PostMapping(value = "/theater", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Theater register(@RequestBody Theater dto) {
		return theaters.insert(dto);
	}

	@DeleteMapping(value = "/{theaterId}")
	public Theater delete(@PathVariable String theaterId) {
		return theaters.delete(theaterId);
	}

	@PutMapping(value = "theater/{theaterId}/{status}")
	public Theater updateStatus(@PathVariable String theaterId, String status) {
		return theaters.updateTheaterStatus(theaterId, Integer.parseInt(status));
	}

	@PutMapping(value = "screen/{theaterId}/{screens}")
	public Theater updateScreen(@PathVariable String theaterId, String screens) {
		return theaters.updateNumberOfScreens(theaterId, Integer.parseInt(screens));

	}

}
