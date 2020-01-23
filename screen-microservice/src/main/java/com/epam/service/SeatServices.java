package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.SeatRequestDto;
import com.epam.dto.SeatResponseDto;

public interface SeatServices {
	public List<SeatResponseDto> insert(List<SeatRequestDto> dto) throws SQLException;

	public List<SeatResponseDto> getSeatByScreen(String screenId);

	public SeatResponseDto getSeatById(String seatId) throws SQLException;

	public void delteByScreenId(List<SeatResponseDto> seats) throws SQLException;

}
