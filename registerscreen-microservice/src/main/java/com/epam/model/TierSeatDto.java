package com.epam.model;

import java.util.List;

import org.springframework.lang.NonNull;

public class TierSeatDto {
	@NonNull
	private TierDto tier;

	@NonNull
	private List<SeatDto> seats;

	public TierDto getTier() {
		return tier;
	}

	public void setTier(TierDto tier) {
		this.tier = tier;
	}

	public List<SeatDto> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatDto> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "TierSeatDto [tier=" + tier + ", seats=" + seats + "]";
	}
}
