package com.epam.service;

import java.util.List;

import com.epam.entity.Dates;

public interface DatesServices {
	public List<Dates> getAll();

	public Dates insert(Dates dto);

	public Dates delete(String dateId);

	public Dates getDateByDateId(String dateId);
}
