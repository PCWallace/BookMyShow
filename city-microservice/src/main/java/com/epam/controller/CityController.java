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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.CityRequestDto;
import com.epam.dto.CityResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.CityListResponse;
import com.epam.response.CityResponse;
import com.epam.response.ErrorResponse;
import com.epam.service.CityServices;

@RestController
public class CityController {

	@Autowired
	private CityServices cities;

	@Autowired
	private CityListResponse cityListResponse;

	@Autowired
	private CityResponse cityResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@GetMapping(value = "/All")
	public ResponseEntity<CityListResponse> getAllCities() throws NoContentFoundException {
		List<CityResponseDto> citiesList = cities.getAll();
		if (citiesList.isEmpty()) {
			throw new NoContentFoundException("There are no city in the database");
		}
		cityListResponse.setDetails(citiesList);
		cityListResponse.setStatus(HttpStatus.OK);
		cityListResponse.setMessage("All the cities in the database");
		return new ResponseEntity<>(cityListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{cityId}")
	public ResponseEntity<CityResponse> getMovieById(@PathVariable String cityId)
			throws SQLException, NoContentFoundException {
		CityResponseDto city;
		try {
			city = cities.getCityById(cityId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No city with this Id");
		}
		cityResponse.setDetails(city);
		cityResponse.setStatus(HttpStatus.OK);
		cityResponse.setMessage("City was found");
		return new ResponseEntity<>(cityResponse, HttpStatus.OK);

	}

	@PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityResponse> register(@RequestBody CityRequestDto dto) throws SQLException {
		CityResponseDto city;
		try {
			city = cities.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		cityResponse.setDetails(city);
		cityResponse.setStatus(HttpStatus.OK);
		cityResponse.setMessage("City get registered");
		return new ResponseEntity<>(cityResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{cityId}")
	public ResponseEntity<ErrorResponse> delete(@PathVariable String cityId)
			throws SQLException, NoContentFoundException {
		CityResponseDto city;
		try {
			city = cities.getCityById(cityId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No city with this Id");
		}
		try {
			cities.delete(city.getCityId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("City Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	}

}
