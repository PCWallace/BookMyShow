package com.epam.dto;

import org.springframework.lang.NonNull;

public class SeatDto {

	@NonNull
	private int rowNumber;

	@NonNull
	private String tierId;

	@NonNull
	private String rowName;

	public SeatDto() {

	}

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
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
		return "SeatDto [rowNumber=" + rowNumber + ", tierId=" + tierId + ", rowName=" + rowName + "]";
	}

}
