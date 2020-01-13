package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.SeatBookingStatus;
import com.epam.repository.SeatBookingStatusRepository;
import com.epam.service.SeatBookingService;

@Service
public class SeatBookingStatusImpl implements SeatBookingService {

	@Autowired
	private SeatBookingStatusRepository seatBookingStatusRepository;

	@Override
	public List<SeatBookingStatus> getSeatBookingStatus(String showId) {
		return seatBookingStatusRepository.findByShowId(showId);
	}

	@Override
	public List<SeatBookingStatus> insert(List<SeatBookingStatus> dto) {
		return seatBookingStatusRepository.saveAll(dto);
	}

	@Override
	public List<SeatBookingStatus> update(List<SeatBookingStatus> dto) {
		return seatBookingStatusRepository.saveAll(dto);
	}

	@Override
	public SeatBookingStatus getBySeatAndShowId(String seatId, String showId) {
		return seatBookingStatusRepository.findByShowIdAndSeatId(showId, seatId);
	}

	@Override
	public List<SeatBookingStatus> getAll() {
		return seatBookingStatusRepository.findAll();
	}

}
