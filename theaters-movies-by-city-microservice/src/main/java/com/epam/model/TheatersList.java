package com.epam.model;

import java.util.ArrayList;
import java.util.List;

public class TheatersList {
	List<Theater> theaters;

	TheatersList() {
		theaters = new ArrayList<>();
	}

	public List<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<Theater> theaters) {
		this.theaters = theaters;
	}

}
