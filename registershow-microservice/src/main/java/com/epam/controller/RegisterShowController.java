package com.epam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.dto.SeatBookingStatusRequestDto;
import com.epam.dto.SeatResponseDto;
import com.epam.dto.ShowRequestDto;
import com.epam.dto.ShowResponseDto;
import com.epam.response.ErrorResponse;
import com.epam.response.SeatBookingStatusListResponse;
import com.epam.response.SeatListResponse;
import com.epam.response.ShowListResponse;

@RestController
public class RegisterShowController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ErrorResponse errorResponse;

	@PostMapping(value = "/show")
	public ResponseEntity<ErrorResponse> getTheShowRegister(@RequestBody List<ShowRequestDto> showDto) {
		ResponseEntity<ShowListResponse> showResponse = restTemplate.postForEntity("http://shows-microservice/show",
				showDto, ShowListResponse.class);
		Map<String, List<SeatResponseDto>> screenIdMap = new HashMap<>();
		List<SeatBookingStatusRequestDto> seatBookingstatusRequest = new ArrayList<>();
		for (ShowResponseDto currentShowRequest : showResponse.getBody().getDetails()) {
			if (screenIdMap.containsKey(currentShowRequest.getScreenId())) {
				for (SeatResponseDto currentSeat : screenIdMap.get(currentShowRequest.getScreenId())) {
					SeatBookingStatusRequestDto seatRequest = new SeatBookingStatusRequestDto();
					seatRequest.setSeatId(currentSeat.getSeatId());
					seatRequest.setShowId(currentShowRequest.getShowId());
					seatRequest.setStatus(1);
					seatBookingstatusRequest.add(seatRequest);
				}
			} else {
				ResponseEntity<SeatListResponse> seatListResponse = restTemplate.getForEntity(
						"http://screen-microservice/seats/" + currentShowRequest.getScreenId(), SeatListResponse.class);
				screenIdMap.put(currentShowRequest.getScreenId(), seatListResponse.getBody().getDetails());
			}
		}

		ResponseEntity<SeatBookingStatusListResponse> seatBookingResponse = restTemplate.postForEntity(
				"http://seatbookingstatus-microservice/seats", seatBookingstatusRequest,
				SeatBookingStatusListResponse.class);
		if (seatBookingResponse.getStatusCode() == HttpStatus.OK) {
			errorResponse.setDetail("shows has been registered");
			errorResponse.setMessage("shows has been registered");
			errorResponse.setStatus(HttpStatus.OK);
		}
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

}
