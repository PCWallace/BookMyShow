package com.epam.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import com.epam.dto.ShowRequestDto;
import com.epam.dto.ShowResponseDto;
import com.epam.entity.ShowsEntity;

public interface ShowMapper {
	public ShowResponseDto toShowDto(ShowsEntity show);

	public List<ShowsEntity> toRegisterShowEntity(List<ShowRequestDto> showDtoList);

	public List<ShowsEntity> toGetRegisterShowEntity(List<ShowResponseDto> showDtoList);

	ShowMapper MAPPER = Mappers.getMapper(ShowMapper.class);

	public List<ShowResponseDto> toShowDtos(List<ShowsEntity> showEntityList);

	public ShowsEntity toShowEntity(ShowRequestDto show);

	public ShowsEntity toShowEntity(ShowResponseDto show);
}
