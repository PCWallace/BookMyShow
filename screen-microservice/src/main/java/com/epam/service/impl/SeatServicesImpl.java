package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.SeatRequestDto;
import com.epam.dto.SeatResponseDto;
import com.epam.mapper.SeatMapper;
import com.epam.repository.SeatRepository;
import com.epam.service.SeatServices;

@Service
public class SeatServicesImpl implements SeatServices {

	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<SeatResponseDto> insert(List<SeatRequestDto> dto) throws SQLException {
		List<SeatResponseDto> seatsList;
		try {
			seatsList = SeatMapper.MAPPER
					.toSeatDtos(seatRepository.saveAll(SeatMapper.MAPPER.toRegisterSeatEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return seatsList;
	}

	@Override
	public SeatResponseDto getSeatById(String seatId) throws SQLException {
		SeatResponseDto seat = SeatMapper.MAPPER.toSeatDto(seatRepository.findBySeatId(seatId));
		if (seat == null)
			throw new SQLException();
		return seat;
	}

	@Override
	public void delteByScreenId(List<SeatResponseDto> seats) throws SQLException {
		try {
			seatRepository.deleteAll(SeatMapper.MAPPER.toGetRegisterSeatEntity(seats));
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public List<SeatResponseDto> getSeatByScreen(String screenId) {
		return SeatMapper.MAPPER.toSeatDtos(seatRepository.findByScreenId(screenId));
	}

	@Override
	public List<SeatResponseDto> getAllSeats() {
		return SeatMapper.MAPPER.toSeatDtos(seatRepository.findAll());
	}

}
