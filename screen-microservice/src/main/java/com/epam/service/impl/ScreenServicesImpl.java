package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Screen;
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
	public Screen insert(Screen dto) {
		return screenRepository.save(dto);
	}

	@Override
	public List<Screen> getAllScreens() {
		return screenRepository.findAll();
	}

}
