package com.epam.dto;

public class TheaterResponseDto {

	private String theaterId;

	private String cityId;

	private String theaterName;

	private String theaterAddress;

	private int numberOfScreens;

	private int active;

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

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

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

	public void setNumberOfScreens(int numberOfScreens) {
		this.numberOfScreens = numberOfScreens;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TheaterResponseDto [theaterId=" + theaterId + ", cityId=" + cityId + ", theaterName=" + theaterName
				+ ", theaterAddress=" + theaterAddress + ", numberOfScreens=" + numberOfScreens + ", active=" + active
				+ "]";
	}
}
