package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "seatbookingstatus")
public class SeatBookingStatus {
	@Id
	@Column(name = "seatBookingStatusId")
	private String seatBookingStatusId;

	@Column(name = "showId")
	private String showId;

	@Column(name = "seatId")
	private String seatId;

	@Column(name = "status")
	private int status;

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

	public String getSeatBookingStatusId() {
		return seatBookingStatusId;
	}

	public void setSeatBookingStatusId(String seatBookingStatusId) {
		this.seatBookingStatusId = seatBookingStatusId;
	}

	public SeatBookingStatus() {
		this.seatBookingStatusId = UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return "SeatBookingStatus [seatBookingStatusId=" + seatBookingStatusId + ", showId=" + showId + ", seatId="
				+ seatId + ", status=" + status + "]";
	}

}
