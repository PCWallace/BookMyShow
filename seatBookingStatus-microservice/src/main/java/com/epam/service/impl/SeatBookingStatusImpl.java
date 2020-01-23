package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.SeatBookingStatusRequestDto;
import com.epam.dto.SeatBookingStatusResponseDto;
import com.epam.entity.SeatBookingStatusEntity;
import com.epam.mapper.SeatBookingStatusMapper;
import com.epam.repository.SeatBookingStatusRepository;
import com.epam.service.SeatBookingService;

@Service
public class SeatBookingStatusImpl implements SeatBookingService {

	@Autowired
	private SeatBookingStatusRepository seatBookingStatusRepository;

	@Override
	public List<SeatBookingStatusResponseDto> getSeatBookingStatus(String showId) {
		return SeatBookingStatusMapper.MAPPER.toSeatBookingStatusDtos(seatBookingStatusRepository.findByShowId(showId));
	}

	@Override
	public List<SeatBookingStatusResponseDto> insert(List<SeatBookingStatusRequestDto> dto) throws SQLException {
		List<SeatBookingStatusResponseDto> seats;
		try {
			seats = SeatBookingStatusMapper.MAPPER.toSeatBookingStatusDtos(seatBookingStatusRepository
					.saveAll(SeatBookingStatusMapper.MAPPER.toRegisterSeatBookingStatusEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return seats;
	}

	@Override
	public List<SeatBookingStatusResponseDto> update(List<SeatBookingStatusResponseDto> dto) throws SQLException {
		List<SeatBookingStatusResponseDto> seats;
		try {
			seats = SeatBookingStatusMapper.MAPPER.toSeatBookingStatusDtos(seatBookingStatusRepository
					.saveAll(SeatBookingStatusMapper.MAPPER.toGetRegisterSeatBookingStatusEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return seats;
	}

	@Override
	public SeatBookingStatusEntity getBySeatAndShowId(String seatId, String showId) {
		return seatBookingStatusRepository.findByShowIdAndSeatId(showId, seatId);
	}

	@Override
	public List<SeatBookingStatusResponseDto> getAll() {
		return SeatBookingStatusMapper.MAPPER.toSeatBookingStatusDtos(seatBookingStatusRepository.findAll());
	}

	@Override
	public SeatBookingStatusResponseDto getSeatBookingStatusBySeatBookingStatusId(String seatBookingStatusId)
			throws SQLException {
		SeatBookingStatusResponseDto seat = SeatBookingStatusMapper.MAPPER
				.toSeatBookingStatusDto(seatBookingStatusRepository.findBySeatBookingStatusId(seatBookingStatusId));
		if (seat == null)
			throw new SQLException();
		return seat;
	}

}
