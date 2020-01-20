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

import com.epam.dto.DateRequestDto;
import com.epam.dto.DateResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.DateListResponse;
import com.epam.response.DateResponse;
import com.epam.response.ErrorResponse;
import com.epam.service.DatesServices;

@RestController
public class DatesController {

	@Autowired
	private DatesServices dates;

	@Autowired
	private DateListResponse dateListResponse;

	@Autowired
	private DateResponse dateResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@GetMapping(value = "/All")
	public ResponseEntity<DateListResponse> getAll() throws NoContentFoundException {
		List<DateResponseDto> dateList = dates.getAll();
		if (dateList.isEmpty()) {
			throw new NoContentFoundException("There are no dates in the database");
		}
		dateListResponse.setDetails(dateList);
		dateListResponse.setStatus(HttpStatus.OK);
		dateListResponse.setMessage("All the adtes in the database");
		return new ResponseEntity<>(dateListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{dateId}")
	public ResponseEntity<DateResponse> getDateById(@PathVariable String dateId) throws NoContentFoundException {
		DateResponseDto date;
		try {
			date = dates.getDateByDateId(dateId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No date with this Id");
		}
		dateResponse.setDetails(date);
		dateResponse.setStatus(HttpStatus.OK);
		dateResponse.setMessage("City was found");
		return new ResponseEntity<>(dateResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/date", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateResponse> inserDate(@RequestBody DateRequestDto dto) throws SQLException {
		DateResponseDto date;
		try {
			date = dates.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		dateResponse.setDetails(date);
		dateResponse.setStatus(HttpStatus.OK);
		dateResponse.setMessage("Date get registered");
		return new ResponseEntity<>(dateResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{dateId}")
	public ResponseEntity<ErrorResponse> deleteDate(@PathVariable String dateId)
			throws NoContentFoundException, SQLException {
		DateResponseDto date;
		try {
			date = dates.getDateByDateId(dateId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No date with this Id");
		}
		try {
			dates.delete(date.getDateId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("City Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
