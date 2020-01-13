package com.epam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.City;
import com.epam.exception.CityLayerException;
import com.epam.service.CityServices;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class CityController {

	@Autowired
	private CityServices cities;

	@GetMapping(value = "/All")
	public List<City> getAllMovies() {
		return cities.getAll();
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/{cityId}")
	@ExceptionHandler(value = CityLayerException.class)
	public ResponseEntity<City> getMovieById(@PathVariable String cityId) {
		try {
			return ResponseEntity.ok(cities.getCityById(cityId));
		} catch (CityLayerException e) {
			return (ResponseEntity<City>) ResponseEntity.badRequest();
		}

	}

	@PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
	public City register(@Valid @RequestBody City dto) {
		return cities.insert(dto);
	}

	@DeleteMapping(value = "/{cityId}")
	public boolean delete(@PathVariable String cityId) throws CityLayerException {
		return cities.delete(cityId);
	}

}
