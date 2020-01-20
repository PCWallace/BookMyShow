package com.epam.service;

import java.util.List;

import com.epam.dto.ScreenResponseDto;
import com.epam.entity.ScreenEntity;

public interface ScreenServices {

	public ScreenEntity insert(ScreenEntity dto);

	public boolean delete(String screenId);

	public List<ScreenResponseDto> getAllScreens();

}
