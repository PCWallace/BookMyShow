package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.TheaterRequestDto;
import com.epam.dto.TheaterResponseDto;

public interface TheaterServices {
	public List<TheaterResponseDto> getAll();

	public TheaterResponseDto getTheaterById(String theaterId) throws SQLException;

	public TheaterResponseDto insert(TheaterRequestDto dto) throws SQLException;

	public TheaterResponseDto updateNumberOfScreens(TheaterResponseDto theaterDto) throws SQLException;

	public TheaterResponseDto updateTheaterStatus(TheaterResponseDto theaterDto) throws SQLException;

	public void delete(String theaterId) throws SQLException;

	List<TheaterResponseDto> getAllTheatersByCityId(String cityId);
}
