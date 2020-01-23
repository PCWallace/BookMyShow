package com.epam.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.epam.dto.TierResponseDto;

@Component
public class TierResponse {
	private String timestamp;

	private HttpStatus status;
	private String message;
	private TierResponseDto details;

	public TierResponseDto getDetails() {
		return details;
	}

	public void setDetails(TierResponseDto details) {
		this.details = details;
	}

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
}
