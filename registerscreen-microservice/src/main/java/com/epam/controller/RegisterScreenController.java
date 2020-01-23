package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.dto.RegisterScreenDto;
import com.epam.dto.ScreenRequestDto;
import com.epam.dto.SeatRequestDto;
import com.epam.dto.TierRequestDto;
import com.epam.dto.TierSeatDto;
import com.epam.response.ScreenResponse;
import com.epam.response.SeatListResponse;
import com.epam.response.TierResponse;

@RestController
public class RegisterScreenController {
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@PostMapping(value = "/addScreen")
	public RegisterScreenDto addScreen(@RequestBody RegisterScreenDto registerScreenDto) {
		ScreenRequestDto screen = registerScreenDto.getScreen();
		int seatsCount = 0;
		ResponseEntity<ScreenResponse> screenResponse = restTemplate.postForEntity("http://screen-microservice/screen",
				screen, ScreenResponse.class);

		if (screenResponse.getStatusCode() == HttpStatus.OK) {
			List<TierSeatDto> tierSeats = registerScreenDto.getTierSeat();
			for (TierSeatDto tierSeat : tierSeats) {
				TierRequestDto tier = tierSeat.getTier();
				tier.setScreenId(screenResponse.getBody().getDetails().getScreenId());
				ResponseEntity<TierResponse> tierResponse = restTemplate
						.postForEntity("http://screen-microservice/tiers/tier", tier, TierResponse.class);
				if (tierResponse.getBody().getStatus() == HttpStatus.OK) {
					List<SeatRequestDto> seatsOfCurrentTier = tierSeat.getSeats();
					seatsCount = seatsCount + seatsOfCurrentTier.size();
					for (SeatRequestDto currentSeat : seatsOfCurrentTier) {
						currentSeat.setTierId(tierResponse.getBody().getDetails().getTierId());
					}
					ResponseEntity<SeatListResponse> seatsList = restTemplate.postForEntity(
							"http://screen-microservice/seats/seat", seatsOfCurrentTier, SeatListResponse.class);
					if (seatsList.getBody().getStatus() != HttpStatus.OK) {

					}
				}

			}
		}
		return registerScreenDto;
	}
}
