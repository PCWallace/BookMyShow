package com.epam.model;

public class SeatResponseDto {
	private String seatId;

	private int rowNumber;

	private String tierId;

	private String rowName;

	private TierDto tier;

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}

	public TierDto getTier() {
		return tier;
	}

	public void setTier(TierDto tier) {
		this.tier = tier;
	}

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

	@Override
	public String toString() {
		return "SeatDto [seatId=" + seatId + ", rowNumber=" + rowNumber + ", tierId=" + tierId + ", rowName=" + rowName
				+ ", tier=" + tier + "]";
	}
}
