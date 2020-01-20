package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.DateRequestDto;
import com.epam.dto.DateResponseDto;
import com.epam.entity.DatesEntity;

@Mapper
public interface DateMapper {
	DateResponseDto toDateDto(DatesEntity date);

	List<DatesEntity> toRegisterDateEntity(List<DateRequestDto> dateDtoList);

	DateMapper MAPPER = Mappers.getMapper(DateMapper.class);

	List<DateResponseDto> toDateDtos(List<DatesEntity> dateEntityList);

	DatesEntity toDateyEntity(DateRequestDto date);
	DatesEntity toDateyEntity(DateResponseDto date);
}
