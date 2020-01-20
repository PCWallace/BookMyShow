package com.epam.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.epam.dto.TheaterResponseDto;

@Component
public class TheaterResponse {
	private String timestamp;

	private HttpStatus status;
	private String message;
	private TheaterResponseDto details;

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

	public TheaterResponseDto getDetails() {
		return details;
	}

	public void setDetails(TheaterResponseDto details) {
		this.details = details;
	}
}
