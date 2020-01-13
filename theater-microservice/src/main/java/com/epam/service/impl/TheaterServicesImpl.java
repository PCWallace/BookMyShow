package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Theater;
import com.epam.repository.TheaterRepository;
import com.epam.service.TheaterServices;

@Service
public class TheaterServicesImpl implements TheaterServices {

	@Autowired
	private TheaterRepository theaterRepository;

	@Override
	public List<Theater> getAll() {
		return theaterRepository.findAll();
	}

	@Override
	public Theater getTheaterById(String theaterId) {
		return theaterRepository.findByTheaterId(theaterId);
	}

	@Override
	public Theater insert(Theater dto) {
		return theaterRepository.save(dto);
	}

	@Override
	public Theater delete(String theaterId) {
		theaterRepository.deleteById(theaterId);
		return getTheaterById(theaterId);
	}

	@Override
	public Theater updateNumberOfScreens(String theaterId, int screen) {
		Theater theater = getTheaterById(theaterId);
		theater.setNumberOfScreens(theater.getNumberOfScreens() + screen);
		return theaterRepository.save(theater);
	}

	@Override
	public Theater updateTheaterStatus(String theaterId, int status) {
		Theater theater = getTheaterById(theaterId);
		theater.setActive(status);
		return theaterRepository.save(theater);
	}

}
