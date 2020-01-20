package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.CityRequestDto;
import com.epam.dto.CityResponseDto;
import com.epam.mapper.CityMapper;
import com.epam.repository.CityRepository;
import com.epam.service.CityServices;

@Service
public class CityServicesImpl implements CityServices {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<CityResponseDto> getAll() {
		return CityMapper.MAPPER.toCityDtos(cityRepository.findAll());
	}

	@Override
	public CityResponseDto getCityById(String cityId) throws SQLException {
		CityResponseDto city = CityMapper.MAPPER.toCityDto(cityRepository.findByCityId(cityId));
		if (city == null)
			throw new SQLException();
		return city;
	}

	@Override
	public CityResponseDto insert(CityRequestDto dto) throws SQLException {
		CityResponseDto city;
		try {
			city = CityMapper.MAPPER.toCityDto(cityRepository.save(CityMapper.MAPPER.toCityEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return city;
	}

	@Override
	public void delete(String cityId) throws SQLException {
		try {
			cityRepository.deleteById(cityId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

}
