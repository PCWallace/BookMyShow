package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.CityRequestDto;
import com.epam.dto.CityResponseDto;
import com.epam.entity.CityEntity;

@Mapper
public interface CityMapper {
	CityResponseDto toCityDto(CityEntity city);

	List<CityEntity> toRegisterCityEntity(List<CityRequestDto> cityDtoList);

	CityMapper MAPPER = Mappers.getMapper(CityMapper.class);

	List<CityResponseDto> toCityDtos(List<CityEntity> cityEntityList);

	CityEntity toCityEntity(CityRequestDto city);
}
