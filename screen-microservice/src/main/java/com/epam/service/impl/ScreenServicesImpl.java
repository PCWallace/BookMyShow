package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.ScreenResponseDto;
import com.epam.entity.ScreenEntity;
import com.epam.mapper.ScreenMapper;
import com.epam.repository.ScreenRepository;
import com.epam.service.ScreenServices;

@Service
public class ScreenServicesImpl implements ScreenServices {

	@Autowired
	private ScreenRepository screenRepository;

	@Override
	public boolean delete(String screenId) {
		screenRepository.deleteById(screenId);
		return true;
	}

	@Override
	public ScreenEntity insert(ScreenEntity dto) {
		return screenRepository.save(dto);
	}

	@Override
	public List<ScreenResponseDto> getAllScreens() {
		return ScreenMapper.MAPPER.toScreenDtos(screenRepository.findAll());
	}
}
