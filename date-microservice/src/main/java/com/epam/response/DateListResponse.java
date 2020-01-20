package com.epam.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.epam.dto.DateResponseDto;

@Component
public class DateListResponse {

	private String timestamp;

	private HttpStatus status;
	private String message;

	private List<DateResponseDto> details;

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

	public List<DateResponseDto> getDetails() {
		return details;
	}

	public void setDetails(List<DateResponseDto> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "DateListResponse [timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", details="
				+ details + "]";
	}

}
