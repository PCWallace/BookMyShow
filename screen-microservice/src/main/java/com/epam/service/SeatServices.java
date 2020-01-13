package com.epam.service;

import java.util.List;

import com.epam.entity.Seat;

public interface SeatServices {
	public List<Seat> insert(List<Seat> dto);

	public boolean delteByScreenId(String screenId);
	
	public List<Seat> getSeatByScreen(String screenId);
	
	
}
