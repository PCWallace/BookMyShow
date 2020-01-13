package com.epam.service;

import java.util.List;

import com.epam.entity.SeatBookingStatus;

public interface SeatBookingService {
	public List<SeatBookingStatus> getSeatBookingStatus(String showId);

	public List<SeatBookingStatus> insert(List<SeatBookingStatus> dto);
	
	public List<SeatBookingStatus> update(List<SeatBookingStatus> dto);
	
	public SeatBookingStatus getBySeatAndShowId(String seatId, String showId);
	
	public List<SeatBookingStatus> getAll();
}
