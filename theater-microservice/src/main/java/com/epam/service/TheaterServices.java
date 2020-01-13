package com.epam.service;

import java.util.List;

import com.epam.entity.Theater;

public interface TheaterServices {
	public List<Theater> getAll();

	public Theater getTheaterById(String theaterId);

	public Theater insert(Theater dto);

	public Theater updateNumberOfScreens(String theaterId, int screen);
	
	public Theater updateTheaterStatus(String theaterId, int status);

	public Theater delete(String theaterId);
}
