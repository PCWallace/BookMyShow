package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.DateRequestDto;
import com.epam.dto.DateResponseDto;
import com.epam.mapper.DateMapper;
import com.epam.repository.DatesRepository;
import com.epam.service.DatesServices;

@Service
public class DatesServicesImpl implements DatesServices {

	@Autowired
	private DatesRepository datesRepository;

	@Override
	public List<DateResponseDto> getAll() {
		return DateMapper.MAPPER.toDateDtos(datesRepository.findAll());
	}

	@Override
	public DateResponseDto insert(DateRequestDto dto) throws SQLException {
		DateResponseDto date;
		try {
			date = DateMapper.MAPPER.toDateDto(datesRepository.save(DateMapper.MAPPER.toDateyEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return date;
	}

	@Override
	public void delete(String dateId) throws SQLException {
		try {
			datesRepository.deleteById(dateId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public DateResponseDto getDateByDateId(String dateId) throws SQLException {
		DateResponseDto date = DateMapper.MAPPER.toDateDto(datesRepository.findByDateId(dateId));
		if (date == null)
			throw new SQLException();
		return date;
	}

}
