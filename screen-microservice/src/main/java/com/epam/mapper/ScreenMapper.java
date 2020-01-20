package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.ScreenRequestDto;
import com.epam.dto.ScreenResponseDto;
import com.epam.entity.ScreenEntity;

@Mapper
public interface ScreenMapper {
	ScreenResponseDto toScreenDto(ScreenEntity screen);

	List<ScreenEntity> toRegisterScreenEntity(List<ScreenRequestDto> screenDtoList);

	ScreenMapper MAPPER = Mappers.getMapper(ScreenMapper.class);

	List<ScreenResponseDto> toScreenDtos(List<ScreenEntity> screenEntityList);

	ScreenEntity toScreenEntity(ScreenRequestDto screen);

	ScreenEntity toScreenEntity(ScreenResponseDto screen);
}
