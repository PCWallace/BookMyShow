package com.epam.dto;

import javax.validation.constraints.NotNull;

public class ScreenRequestDto {

	@NotNull(message = "must contain Theater Id")
	private String theaterId;

	@NotNull(message = "must contain screen name")
	private String screenName;

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

	@Override
	public String toString() {
		return "ScreenRequestDto [theaterId=" + theaterId + ", screenName=" + screenName + "]";
	}

}
