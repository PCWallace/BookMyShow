package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.DateRequestDto;
import com.epam.dto.DateResponseDto;

public interface DatesServices {
	public List<DateResponseDto> getAll();

	public DateResponseDto insert(DateRequestDto dto) throws SQLException;

	public void delete(String dateId) throws SQLException;

	public DateResponseDto getDateByDateId(String dateId) throws SQLException;
}
