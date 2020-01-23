package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.ScreenRequestDto;
import com.epam.dto.ScreenResponseDto;

public interface ScreenServices {

	public ScreenResponseDto insert(ScreenRequestDto dto) throws SQLException;

	public void delete(String screenId) throws SQLException;

	public List<ScreenResponseDto> getAllScreens();
	
	public List<ScreenResponseDto> getAllScreensByTheaterId(String theaterId);

	public ScreenResponseDto getScreenByScreenId(String screenId) throws SQLException;

}
