package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.TierRequestDto;
import com.epam.dto.TierResponseDto;
import com.epam.entity.ScreenEntity;
import com.epam.entity.TierEntity;

@Mapper
public interface TierMapper {
	TierResponseDto toTierDto(ScreenEntity tier);

	List<TierEntity> toRegisterTierEntity(List<TierRequestDto> tierDtoList);

	TierMapper MAPPER = Mappers.getMapper(TierMapper.class);

	List<TierResponseDto> toTierDtos(List<TierEntity> tierEntityList);

	ScreenEntity toTierEntity(TierRequestDto tier);

	ScreenEntity toTierEntity(TierResponseDto tier);
}
