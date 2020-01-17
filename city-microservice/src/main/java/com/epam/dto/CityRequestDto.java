package com.epam.dto;

import javax.validation.constraints.NotNull;

public class CityRequestDto {

	@NotNull(message = "must contain city name")
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityDto [cityName=" + cityName + "]";
	}

}
