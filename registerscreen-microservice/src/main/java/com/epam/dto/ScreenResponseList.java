package com.epam.dto;

import java.util.List;

public class ScreenResponseList {
	private List<ScreenResponseDto> screenResponseList;

	public ScreenResponseList() {

	}

	public List<ScreenResponseDto> getScreenResponseList() {
		return screenResponseList;
	}

	public void setScreenResponseList(List<ScreenResponseDto> screenResponseList) {
		this.screenResponseList = screenResponseList;
	}

	@Override
	public String toString() {
		return "ScreenResponseList [screenResponseList=" + screenResponseList + "]";
	}

}
