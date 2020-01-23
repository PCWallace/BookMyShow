package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.SeatBookingStatusRequestDto;
import com.epam.dto.SeatBookingStatusResponseDto;
import com.epam.entity.SeatBookingStatusEntity;

public interface SeatBookingService {
	public List<SeatBookingStatusResponseDto> getSeatBookingStatus(String showId);

	public List<SeatBookingStatusResponseDto> insert(List<SeatBookingStatusRequestDto> dto) throws SQLException;
	
	public List<SeatBookingStatusResponseDto> update(List<SeatBookingStatusResponseDto> dto) throws SQLException;
	
	public SeatBookingStatusEntity getBySeatAndShowId(String seatId, String showId);
	
	public List<SeatBookingStatusResponseDto> getAll();

	public SeatBookingStatusResponseDto getSeatBookingStatusBySeatBookingStatusId(String seatBookingStatusId) throws SQLException;
}
