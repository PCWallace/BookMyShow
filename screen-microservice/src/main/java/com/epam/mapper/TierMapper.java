package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.TierRequestDto;
import com.epam.dto.TierResponseDto;
import com.epam.entity.TierEntity;

@Mapper
public interface TierMapper {
	TierResponseDto toTierDto(TierEntity tier);

	List<TierEntity> toRegisterTierEntity(List<TierRequestDto> tierDtoList);

	TierMapper MAPPER = Mappers.getMapper(TierMapper.class);

	List<TierResponseDto> toTierDtos(List<TierEntity> tierEntityList);

	TierEntity toTierEntity(TierRequestDto tier);

	TierEntity toTierEntity(TierResponseDto tier);
}
