package com.epam.service;

import java.util.List;

import com.epam.entity.Screen;

public interface ScreenServices {

	public Screen insert(Screen dto);

	public boolean delete(String screenId);

	public List<Screen> getAllScreens();

}
