package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.TheaterRequestDto;
import com.epam.dto.TheaterResponseDto;
import com.epam.entity.TheaterEntity;

@Mapper
public interface TheaterMapper {
	TheaterResponseDto toTheaterDto(TheaterEntity theater);

	List<TheaterEntity> toRegisterTheaterEntity(List<TheaterRequestDto> cityDtoList);

	TheaterMapper MAPPER = Mappers.getMapper(TheaterMapper.class);

	List<TheaterResponseDto> toTheaterDtos(List<TheaterEntity> theaterEntityList);

	TheaterEntity toTheaterEntity(TheaterRequestDto theater);
	
	TheaterEntity toTheaterEntity(TheaterResponseDto theater);
}
