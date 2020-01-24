package com.epam.dto;

public class SeatResponseDto {

	private String seatId;

	private int rowNumber;

	private String rowName;

	private String tierId;

	private TierResponseDto tier;

	public String getSeatId() {
		return seatId;
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

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}

	public TierResponseDto getTier() {
		return tier;
	}

	public void setTier(TierResponseDto tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "SeatResponseDto [seatId=" + seatId + ", rowNumber=" + rowNumber + ", rowName=" + rowName + ", tierId="
				+ tierId + ", tier=" + tier + "]";
	}

}
