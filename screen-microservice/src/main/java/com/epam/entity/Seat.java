package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "seat")
public class Seat {
	@Id
	@Column(name = "seatId")
	private String seatId;

	@Column(name = "rowNumber")
	private int rowNumber;

	@Column(name = "rowName")
	private String rowName;

	@Column(name = "tierId")
	private String tierId;

	@ManyToOne
	@JoinColumn(name = "tierId", insertable = false, updatable = false)
	private Tier tier;

	public Seat() {
		this.seatId = UUID.randomUUID().toString();
	}

	public String getSeatId() {
		return seatId;
	}

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", rowNumber=" + rowNumber + ", rowName=" + rowName + ", tierId=" + tierId
				+ ", tier=" + tier + "]";
	}

}
