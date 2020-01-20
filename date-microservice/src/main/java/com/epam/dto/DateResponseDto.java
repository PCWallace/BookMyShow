package com.epam.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateResponseDto {

	private String dateId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfShows;

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public Date getDateOfShows() {
		return dateOfShows;
	}

	public void setDateOfShows(Date dateOfShows) {
		this.dateOfShows = dateOfShows;
	}

	@Override
	public String toString() {
		return "Dates [dateId=" + dateId + ", dateOfShows=" + dateOfShows + "]";
	}
}
