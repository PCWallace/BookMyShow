package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.SeatBookingStatusRequestDto;
import com.epam.dto.SeatBookingStatusResponseDto;
import com.epam.entity.SeatBookingStatusEntity;

@Mapper
public interface SeatBookingStatusMapper {
	SeatBookingStatusResponseDto toSeatBookingStatusDto(SeatBookingStatusEntity city);

	List<SeatBookingStatusEntity> toRegisterSeatBookingStatusEntity(List<SeatBookingStatusRequestDto> cityDtoList);

	List<SeatBookingStatusEntity> toGetRegisterSeatBookingStatusEntity(List<SeatBookingStatusResponseDto> cityDtoList);

	SeatBookingStatusMapper MAPPER = Mappers.getMapper(SeatBookingStatusMapper.class);

	List<SeatBookingStatusResponseDto> toSeatBookingStatusDtos(List<SeatBookingStatusEntity> cityEntityList);

	SeatBookingStatusEntity toSeatBookingStatusEntity(SeatBookingStatusRequestDto city);

	SeatBookingStatusEntity toSeatBookingStatusEntity(SeatBookingStatusResponseDto city);
}
