package com.epam.entity;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "order")
public class Order {
	@Id
	@Column(name = "orderId")
	private String orderId;

	@Column(name = "showId")
	private String showId;

	@Column(name = "seatId")
	private String seatId;

	@Column(name = "status")
	private int status;

	@Column(name = "timestamp")
	private Time timestamp;

	public Time getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Time timestamp) {
		this.timestamp = timestamp;
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

	public String getSeatBookingStatusId() {
		return orderId;
	}

	public void setSeatBookingStatusId(String seatBookingStatusId) {
		this.orderId = seatBookingStatusId;
	}

	public Order() {
		this.timestamp = Time.valueOf(LocalTime.now());
	}

}
