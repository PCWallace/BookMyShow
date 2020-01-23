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
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.ScreenRequestDto;
import com.epam.dto.ScreenResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.ErrorResponse;
import com.epam.response.ScreenListResponse;
import com.epam.response.ScreenResponse;
import com.epam.service.ScreenServices;

@RestController
public class ScreenController {
	@Autowired
	private ScreenServices screens;

	@Autowired
	private ScreenListResponse screenListResponse;

	@Autowired
	private ScreenResponse screenResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@PostMapping(value = "/screen")
	public ResponseEntity<ScreenResponse> insert(@RequestBody ScreenRequestDto dto) throws SQLException {
		ScreenResponseDto screen;
		try {
			screen = screens.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		screenResponse.setDetails(screen);
		screenResponse.setStatus(HttpStatus.OK);
		screenResponse.setMessage("City get registered");
		return new ResponseEntity<>(screenResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{screenId}")
	public ResponseEntity<ErrorResponse> delete(@PathVariable String screenId)
			throws NoContentFoundException, SQLException {
		ScreenResponseDto screen;
		try {
			screen = screens.getScreenByScreenId(screenId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No screen with this Id");
		}
		try {
			screens.delete(screen.getScreenId());
		} catch (SQLException e) {
			throw new SQLException("Could not able to delete something went wrong");
		}
		errorResponse.setStatus(HttpStatus.OK);
		errorResponse.setMessage("OK");
		errorResponse.setDetail("Screen Deleted Successfully");
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{screenId}")
	public ResponseEntity<ScreenResponse> getScreenByScreenID(@PathVariable String screenId)
			throws SQLException, NoContentFoundException {
		ScreenResponseDto screen;
		try {
			screen = screens.getScreenByScreenId(screenId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No screen with this Id");
		}
		screenResponse.setDetails(screen);
		screenResponse.setStatus(HttpStatus.OK);
		screenResponse.setMessage("Screen was found");
		return new ResponseEntity<>(screenResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/All")
	public ResponseEntity<ScreenListResponse> getAll() throws NoContentFoundException {
		List<ScreenResponseDto> screensList = screens.getAllScreens();
		if (screensList.isEmpty()) {
			throw new NoContentFoundException("There are no screen in the database");
		}
		screenListResponse.setDetails(screensList);
		screenListResponse.setStatus(HttpStatus.OK);
		screenListResponse.setMessage("All the screens in the database");
		return new ResponseEntity<>(screenListResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/theater/{theaterId}")
	public ResponseEntity<ScreenListResponse> getAllScreensByTheaterId(@PathVariable String theaterId) throws NoContentFoundException {
		List<ScreenResponseDto> screensList = screens.getAllScreensByTheaterId(theaterId);
		if (screensList.isEmpty()) {
			throw new NoContentFoundException("There are no screen in the database");
		}
		screenListResponse.setDetails(screensList);
		screenListResponse.setStatus(HttpStatus.OK);
		screenListResponse.setMessage("All the screens in the of the theater");
		return new ResponseEntity<>(screenListResponse, HttpStatus.OK);
	}
}
