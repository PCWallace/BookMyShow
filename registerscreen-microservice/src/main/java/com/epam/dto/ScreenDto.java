package com.epam.dto;

import org.springframework.lang.NonNull;

public class ScreenDto {

	@NonNull
	private String theaterId;

	@NonNull
	private String screenName;

	public ScreenDto() {

	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
