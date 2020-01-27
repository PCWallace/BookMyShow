package com.epam.dto;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TheaterViewResponseDto {
	private Map<MovieResponseDto, List<ShowResponseDto>> theaterViewMap;

	public Map<MovieResponseDto, List<ShowResponseDto>> getTheaterViewMap() {
		return theaterViewMap;
	}

	public void setTheaterViewMap(Map<MovieResponseDto, List<ShowResponseDto>> theaterViewMap) {
		this.theaterViewMap = theaterViewMap;
	}
}
