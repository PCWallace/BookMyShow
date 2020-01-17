package com.epam.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.epam.dto.CityResponseDto;

public class CityListResponse {
	private String timestamp;

	private HttpStatus status;
	private String message;

	private List<CityResponseDto> citiesList;

	public String getTimestamp() {
		LocalDateTime currentTime = LocalDateTime.now();
		this.timestamp = currentTime.toString();
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CityResponseDto> getCitiesList() {
		return citiesList;
	}

	public void setCitiesList(List<CityResponseDto> citiesList) {
		this.citiesList = citiesList;
	}

}
