package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.TheaterRequestDto;
import com.epam.dto.TheaterResponseDto;
import com.epam.mapper.TheaterMapper;
import com.epam.repository.TheaterRepository;
import com.epam.service.TheaterServices;

@Service
public class TheaterServicesImpl implements TheaterServices {

	@Autowired
	private TheaterRepository theaterRepository;

	@Override
	public List<TheaterResponseDto> getAll() {
		return TheaterMapper.MAPPER.toTheaterDtos(theaterRepository.findAll());
	}
	
	@Override
	public List<TheaterResponseDto> getAllTheatersByCityId(String cityId) {
		return TheaterMapper.MAPPER.toTheaterDtos(theaterRepository.findByCityId(cityId));
	}

	@Override
	public TheaterResponseDto getTheaterById(String theaterId) throws SQLException {
		TheaterResponseDto theater = TheaterMapper.MAPPER.toTheaterDto(theaterRepository.findByTheaterId(theaterId));
		if (theater == null)
			throw new SQLException();
		return theater;
	}

	@Override
	public TheaterResponseDto insert(TheaterRequestDto dto) throws SQLException {
		TheaterResponseDto theater;
		try {
			theater = TheaterMapper.MAPPER
					.toTheaterDto(theaterRepository.save(TheaterMapper.MAPPER.toTheaterEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return theater;
	}

	@Override
	public void delete(String theaterId) throws SQLException {
		try {
			theaterRepository.deleteById(theaterId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public TheaterResponseDto updateNumberOfScreens(TheaterResponseDto theaterDto) throws SQLException {
		TheaterResponseDto theater;
		try {
			theater = TheaterMapper.MAPPER
					.toTheaterDto(theaterRepository.save(TheaterMapper.MAPPER.toTheaterEntity(theaterDto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return theater;
	}

	@Override
	public TheaterResponseDto updateTheaterStatus(TheaterResponseDto theaterDto) throws SQLException {
		TheaterResponseDto theater;
		try {
			theater = TheaterMapper.MAPPER
					.toTheaterDto(theaterRepository.save(TheaterMapper.MAPPER.toTheaterEntity(theaterDto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return theater;
	}

}
