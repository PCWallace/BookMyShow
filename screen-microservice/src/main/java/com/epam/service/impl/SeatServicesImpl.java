package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Seat;
import com.epam.repository.SeatRepository;
import com.epam.service.SeatServices;

@Service
public class SeatServicesImpl implements SeatServices {

	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<Seat> insert(List<Seat> dto) {
		return seatRepository.saveAll(dto);
	}

	@Override
	public boolean delteByScreenId(String screenId) {
		seatRepository.deleteById(screenId);
		return true;
	}

	@Override
	public List<Seat> getSeatByScreen(String screenId) {
		return seatRepository.findByScreenId(screenId);
	}

}
