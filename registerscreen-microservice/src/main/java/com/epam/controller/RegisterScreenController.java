package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.epam.model.RegisterScreenDto;
import com.epam.model.ScreenDto;
import com.epam.model.ScreenResponseDto;
import com.epam.model.SeatDto;
import com.epam.model.SeatResponseDto;
import com.epam.model.TierDto;
import com.epam.model.TierResponseDto;
import com.epam.model.TierSeatDto;

@RestController
public class RegisterScreenController {
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@PostMapping(value = "/addScreen")
	public RegisterScreenDto addScreen(@RequestBody RegisterScreenDto registerScreenDto) {
		ScreenDto screen = registerScreenDto.getScreen();
		int seatsCount = 0;
		ResponseEntity<ScreenResponseDto> screenResponse = restTemplate
				.postForEntity("http://screen-microservice/screen", screen, ScreenResponseDto.class);

		if (screenResponse.getStatusCode() == HttpStatus.OK) {
			List<TierSeatDto> tierSeats = registerScreenDto.getTierSeat();
			for (TierSeatDto tierSeat : tierSeats) {
				TierDto tier = tierSeat.getTier();
				tier.setScreenId(screenResponse.getBody().getScreenId());
				ResponseEntity<TierResponseDto> tierResponse = restTemplate
						.postForEntity("http://screen-microservice/tiers/tier", tier, TierResponseDto.class);
				List<SeatDto> seatsOfCurrentTier = tierSeat.getSeats();
				seatsCount = seatsCount + seatsOfCurrentTier.size();
				for (SeatDto currentSeat : seatsOfCurrentTier) {
					currentSeat.setTierId(tierResponse.getBody().getTierId());
				}
				ResponseEntity<SeatResponseDto[]> seatResponse = restTemplate.postForEntity("http://screen-microservice/seats/seat",
						seatsOfCurrentTier,SeatResponseDto[].class);
//				ResponseEntity<List<SeatResponseDto>> seatResponses = restTemplate.exchange(
//						"http://screen-microservice/seats/seat", HttpMethod.GET, null,
//						new ParameterizedTypeReference<List<SeatResponseDto>>() {
//						});
			}
		}
		return registerScreenDto;
	}
}
