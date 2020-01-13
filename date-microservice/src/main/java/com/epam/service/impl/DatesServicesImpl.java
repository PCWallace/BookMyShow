package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Dates;
import com.epam.repository.DatesRepository;
import com.epam.service.DatesServices;

@Service
public class DatesServicesImpl implements DatesServices {

	@Autowired
	private DatesRepository datesRepository;

	@Override
	public List<Dates> getAll() {
		return datesRepository.findAll();
	}

	@Override
	public Dates insert(Dates dto) {
		return datesRepository.save(dto);
	}

	@Override
	public Dates delete(String dateId) {
		datesRepository.deleteById(dateId);
		return getDateByDateId(dateId);
	}

	@Override
	public Dates getDateByDateId(String dateId) {
		return datesRepository.findByDateId(dateId);
	}

}
