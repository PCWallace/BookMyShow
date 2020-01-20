package com.epam.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateRequestDto {
	@NotNull(message = "Date shgould be present")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfShows;

	public Date getDateOfShows() {
		return dateOfShows;
	}

	public void setDateOfShows(Date dateOfShows) {
		this.dateOfShows = dateOfShows;
	}

	@Override
	public String toString() {
		return "DateRequestDto [dateOfShows=" + dateOfShows + "]";
	}
}
