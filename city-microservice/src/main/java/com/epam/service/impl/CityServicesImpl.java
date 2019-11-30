package com.epam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.constant.ApplicationConstants;
import com.epam.entity.City;
import com.epam.exception.CityLayerException;
import com.epam.repository.CityRepository;
import com.epam.service.CityServices;

@Service
public class CityServicesImpl implements CityServices {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> getAll() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityById(String cityId) throws CityLayerException {
		City city = cityRepository.findByCityId(cityId);
		Optional.ofNullable(city)
				.orElseThrow(() -> new CityLayerException(ApplicationConstants.CITY_NOT_FOUND.toString()));
		return city;
	}

	@Override
	public City insert(City dto) {
		return cityRepository.save(dto);
	}

	@Override
	public boolean delete(String cityId) throws CityLayerException {
		boolean deleteStatus = true;
		City city = getCityById(cityId);
		cityRepository.deleteById(cityId);
		city = cityRepository.findByCityId(cityId);
		if (Optional.ofNullable(city).isPresent()) {
			deleteStatus = false;
			throw new CityLayerException(ApplicationConstants.NOT_DELETED.toString());
		}
		return deleteStatus;
	}

}
