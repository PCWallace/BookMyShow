package com.epam.dto;

public class CityResponseDto {
	private String cityName;

	private String cityId;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "CityResponseDto [cityName=" + cityName + ", cityId=" + cityId + "]";
	}

}
