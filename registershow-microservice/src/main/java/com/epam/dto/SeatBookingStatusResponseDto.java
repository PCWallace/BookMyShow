package com.epam.dto;

public class SeatBookingStatusResponseDto {
	private String seatBookingStatusId;

	private String showId;

	private String seatId;

	private int status;

	public String getSeatBookingStatusId() {
		return seatBookingStatusId;
	}

	public void setSeatBookingStatusId(String seatBookingStatusId) {
		this.seatBookingStatusId = seatBookingStatusId;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
