package com.epam.service;

import java.util.List;

import com.epam.entity.City;
import com.epam.exception.CityLayerException;

public interface CityServices {
	public List<City> getAll();

	public City getCityById(String cityId) throws CityLayerException ;

	public City insert(City dto);

	public boolean delete(String cityId) throws CityLayerException ;
}
