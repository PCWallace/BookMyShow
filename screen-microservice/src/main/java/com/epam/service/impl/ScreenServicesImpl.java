package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.ScreenRequestDto;
import com.epam.dto.ScreenResponseDto;
import com.epam.mapper.ScreenMapper;
import com.epam.repository.ScreenRepository;
import com.epam.service.ScreenServices;

@Service
public class ScreenServicesImpl implements ScreenServices {

	@Autowired
	private ScreenRepository screenRepository;

	@Override
	public void delete(String screenId) throws SQLException {
		try {
			screenRepository.deleteById(screenId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public ScreenResponseDto insert(ScreenRequestDto dto) throws SQLException {
		ScreenResponseDto city;
		try {
			city = ScreenMapper.MAPPER.toScreenDto(screenRepository.save(ScreenMapper.MAPPER.toScreenEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return city;
	}

	@Override
	public List<ScreenResponseDto> getAllScreens() {
		return ScreenMapper.MAPPER.toScreenDtos(screenRepository.findAll());
	}

	@Override
	public ScreenResponseDto getScreenByScreenId(String screenId) throws SQLException {
		ScreenResponseDto screen = ScreenMapper.MAPPER.toScreenDto(screenRepository.findByScreenId(screenId));
		if (screen == null)
			throw new SQLException();
		return screen;
	}

	@Override
	public List<ScreenResponseDto> getAllScreensByTheaterId(String theaterId) {
		return ScreenMapper.MAPPER.toScreenDtos(screenRepository.findByTheaterId(theaterId));
	}
}
