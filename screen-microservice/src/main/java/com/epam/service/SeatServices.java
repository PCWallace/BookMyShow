package com.epam.service;

import java.util.List;

import com.epam.entity.SeatEntity;

public interface SeatServices {
	public List<SeatEntity> insert(List<SeatEntity> dto);

	public boolean delteByScreenId(String screenId);
	
	public List<SeatEntity> getSeatByScreen(String screenId);
	
	
}
