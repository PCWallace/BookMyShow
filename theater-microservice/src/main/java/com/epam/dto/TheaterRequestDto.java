package com.epam.dto;

import javax.validation.constraints.NotNull;

public class TheaterRequestDto {
	@NotNull(message = "City id shgould be present")
	private String cityId;

	@NotNull(message = "Theater name shgould be present")
	private String theaterName;

	@NotNull(message = "theater address shgould be present")
	private String theaterAddress;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	@Override
	public String toString() {
		return "TheaterRequestDto [cityId=" + cityId + ", theaterName=" + theaterName + ", theaterAddress="
				+ theaterAddress + "]";
	}
}
