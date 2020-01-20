package com.epam.dto;

import javax.validation.constraints.NotNull;

public class SeatRequestDto {

	@NotNull(message = "must contain row numner")
	private int rowNumber;

	@NotNull(message = "must contain row name")
	private String rowName;

	@NotNull(message = "must contain tier id")
	private String tierId;

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

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}

	@Override
	public String toString() {
		return "SeatRequestDto [rowNumber=" + rowNumber + ", rowName=" + rowName + ", tierId=" + tierId + "]";
	}
}
