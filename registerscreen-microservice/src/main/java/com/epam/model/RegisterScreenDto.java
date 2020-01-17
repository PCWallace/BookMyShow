package com.epam.model;

import java.util.List;

public class RegisterScreenDto {
	private ScreenDto screen;

	private int seats;

	private List<TierSeatDto> tierSeat;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public ScreenDto getScreen() {
		return screen;
	}

	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}

	public List<TierSeatDto> getTierSeat() {
		return tierSeat;
	}

	public void setTierSeat(List<TierSeatDto> tierSeat) {
		this.tierSeat = tierSeat;
	}
}
