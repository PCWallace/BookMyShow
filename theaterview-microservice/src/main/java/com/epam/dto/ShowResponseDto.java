package com.epam.dto;

public class ShowResponseDto {

	private String showId;

	private String dateId;

	private String movieId;

	private String screenId;

	private String showTiming;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

	@Override
	public String toString() {
		return "ShowResponseDto [showId=" + showId + ", dateId=" + dateId + ", movieId=" + movieId + ", screenId="
				+ screenId + ", showTiming=" + showTiming + "]";
	}

}
