package com.epam.service;

import java.util.List;

import com.epam.entity.Shows;

public interface ShowsServices {
	public List<Shows> getAll();

	public Shows getShowById(String showId);

	public List<Shows> insertAll(List<Shows> showsDto);

	public Shows delete(String theaterId);
}
