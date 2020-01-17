package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.CityRequestDto;
import com.epam.dto.CityResponseDto;

public interface CityServices {
	public List<CityResponseDto> getAll();

	public CityResponseDto getCityById(String cityId) throws SQLException;

	public CityResponseDto insert(CityRequestDto dto) throws SQLException;

	public void delete(String cityId) throws SQLException;

}
