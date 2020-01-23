package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.SeatRequestDto;
import com.epam.dto.SeatResponseDto;
import com.epam.entity.SeatEntity;

@Mapper
public interface SeatMapper {
	SeatResponseDto toSeatDto(SeatEntity seat);

	public List<SeatEntity> toRegisterSeatEntity(List<SeatRequestDto> seatDtoList);

	public List<SeatEntity> toGetRegisterSeatEntity(List<SeatResponseDto> seatDtoList);

	SeatMapper MAPPER = Mappers.getMapper(SeatMapper.class);

	List<SeatResponseDto> toSeatDtos(List<SeatEntity> seatEntityList);

	SeatEntity toSeatEntity(SeatRequestDto seat);

	SeatEntity toSeatEntity(SeatResponseDto seat);
}
