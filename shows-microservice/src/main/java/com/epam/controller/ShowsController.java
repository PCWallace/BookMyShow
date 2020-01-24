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

import com.epam.dto.ShowRequestDto;
import com.epam.dto.ShowResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.ErrorResponse;
import com.epam.response.ShowListResponse;
import com.epam.response.ShowResponse;
import com.epam.service.ShowsServices;

@RestController
public class ShowsController {

	@Autowired
	private ShowsServices showsServices;

	@Autowired
	private ShowListResponse showListResponse;

	@Autowired
	private ShowResponse showResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@GetMapping(value = "/All")
	public ResponseEntity<ShowListResponse> getAllShows() throws NoContentFoundException {
		List<ShowResponseDto> showsList = showsServices.getAll();
		if (showsList.isEmpty()) {
			throw new NoContentFoundException("There are no shows in the database");
		}
		showListResponse.setDetails(showsList);
		showListResponse.setStatus(HttpStatus.OK);
		showListResponse.setMessage("All the cities in the database");
		return new ResponseEntity<>(showListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/screen/{screenId}")
	public ResponseEntity<ShowListResponse> getAllShowsByScreenId(@PathVariable String screenId)
			throws NoContentFoundException {
		List<ShowResponseDto> showsList = showsServices.getAllShowsByScreenId(screenId);
		if (showsList.isEmpty()) {
			throw new NoContentFoundException("There are no shows in the database");
		}
		showListResponse.setDetails(showsList);
		showListResponse.setStatus(HttpStatus.OK);
		showListResponse.setMessage("All the cities in the database");
		return new ResponseEntity<>(showListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "{/showId}")
	public ResponseEntity<ShowResponse> getSowsByShowId(@PathVariable String showId) throws NoContentFoundException {
		ShowResponseDto show;
		try {
			show = showsServices.getShowById(showId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No show with this Id");
		}
		showResponse.setDetails(show);
		showResponse.setStatus(HttpStatus.OK);
		showResponse.setMessage("Show was found");
		return new ResponseEntity<>(showResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/show", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShowListResponse> insertTheShow(@RequestBody List<ShowRequestDto> showList)
			throws SQLException {
		List<ShowResponseDto> showsList;
		try {
			showsList = showsServices.insertAll(showList);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		showListResponse.setDetails(showsList);
		showListResponse.setStatus(HttpStatus.OK);
		showListResponse.setMessage("shows get registered");
		return new ResponseEntity<>(showListResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{showId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorResponse> deletbyShowsId(@PathVariable String showId)
			throws NoContentFoundException, SQLException {
		ShowResponseDto show;
		try {
			show = showsServices.getShowById(showId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No show with this Id");
		}
		try {
			showsServices.delete(show.getShowId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("City Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
