package com.epam.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.epam.dto.ScreenResponseDto;

@Component
public class ScreenListResponse {
	private String timestamp;

	private HttpStatus status;
	private String message;

	private List<ScreenResponseDto> details;

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

	public List<ScreenResponseDto> getDetails() {
		return details;
	}

	public void setDetails(List<ScreenResponseDto> details) {
		this.details = details;
	}
}
