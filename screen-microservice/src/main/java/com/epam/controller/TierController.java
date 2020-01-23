package com.epam.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.TierRequestDto;
import com.epam.dto.TierResponseDto;
import com.epam.exception.NoContentFoundException;
import com.epam.response.TierListResponse;
import com.epam.response.TierResponse;
import com.epam.service.TierService;

@RestController
@RequestMapping(value = "/tiers")
public class TierController {
	@Autowired
	private TierService tiers;

	@Autowired
	private TierListResponse tierListResponse;
	
	@Autowired
	private TierResponse tierResponse;

	@GetMapping(value = "All")
	public ResponseEntity<TierListResponse> getAllTiers() throws NoContentFoundException {
		List<TierResponseDto> tiersList = tiers.getAllTiers();
		if (tiersList.isEmpty()) {
			throw new NoContentFoundException("There are no screen in the database");
		}
		tierListResponse.setDetails(tiersList);
		tierListResponse.setStatus(HttpStatus.OK);
		tierListResponse.setMessage("All the tiers in the database");
		return new ResponseEntity<>(tierListResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/tier")
	public ResponseEntity<TierResponse> insert(@RequestBody TierRequestDto dto) throws SQLException {
		TierResponseDto tier;
		try {
			tier = tiers.insert(dto);
		} catch (SQLException e) {
			throw new SQLException("Something went could not able to save");
		}
		tierResponse.setDetails(tier);
		tierResponse.setStatus(HttpStatus.OK);
		tierResponse.setMessage("City get registered");
		return new ResponseEntity<>(tierResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/{tierId}")
	public ResponseEntity<TierResponse> getMovieById(@PathVariable String tierId)
			throws SQLException, NoContentFoundException {
		TierResponseDto tier;
		try {
			tier = tiers.getTierByTierId(tierId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No tier with this Id");
		}
		tierResponse.setDetails(tier);
		tierResponse.setStatus(HttpStatus.OK);
		tierResponse.setMessage("Tier was found");
		return new ResponseEntity<>(tierResponse, HttpStatus.OK);
	}
	@PutMapping(value = "/tier/{tierId}/{cost}")
	public ResponseEntity<TierResponse> update(@PathVariable String tierId, int cost)
			throws SQLException, NoContentFoundException {
		TierResponseDto tier;
		try {
			tier = tiers.getTierByTierId(tierId);
		} catch (SQLException e) {
			throw new NoContentFoundException("No tier with this Id");
		}
		tier.setCost(cost);
		try {
			tier = tiers.update(tier);
		} catch (SQLException e) {
			throw new SQLException("Number of screens of theater does not get updated");
		}
		tierResponse.setDetails(tier);
		tierResponse.setStatus(HttpStatus.OK);
		tierResponse.setMessage("Tier screens get updated");
		return new ResponseEntity<>(tierResponse, HttpStatus.OK);
	}
}
