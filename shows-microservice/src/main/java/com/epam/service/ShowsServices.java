package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.ShowRequestDto;
import com.epam.dto.ShowResponseDto;

public interface ShowsServices {
	public List<ShowResponseDto> getAll();

	public ShowResponseDto getShowById(String showId) throws SQLException;

	public void delete(String theaterId) throws SQLException;

	List<ShowResponseDto> insertAll(List<ShowRequestDto> showsDto) throws SQLException;

	List<ShowResponseDto> getAllShowsByScreenId(String screenId);
}
