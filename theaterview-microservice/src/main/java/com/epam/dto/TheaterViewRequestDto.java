package com.epam.dto;

public class TheaterViewRequestDto {
	private String theaterId;

	private String dateId;

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	@Override
	public String toString() {
		return "TheaterViewRequestDto [theaterId=" + theaterId + ", dateId=" + dateId + "]";
	}
}
