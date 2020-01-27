package com.epam.dto;

public class ScreenResponseDto {

	private String screenId;

	private String theaterId;

	private String screenName;

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
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

	@Override
	public String toString() {
		return "ScreenResponseDto [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ "]";
	}
}
