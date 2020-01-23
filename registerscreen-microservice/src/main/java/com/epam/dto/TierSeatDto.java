package com.epam.dto;

import java.util.List;

import org.springframework.lang.NonNull;

public class TierSeatDto {
	@NonNull
	private TierRequestDto tier;

	@NonNull
	private List<SeatRequestDto> seats;

	public TierRequestDto getTier() {
		return tier;
	}

	public void setTier(TierRequestDto tier) {
		this.tier = tier;
	}

	public List<SeatRequestDto> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatRequestDto> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "TierSeatDto [tier=" + tier + ", seats=" + seats + "]";
	}
}
