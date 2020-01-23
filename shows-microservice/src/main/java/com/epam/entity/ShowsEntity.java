package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "shows")
public class ShowsEntity {
	@Id
	@Column(name = "showId")
	private String showId;

	@Column(name = "dateId")
	private String dateId;

	@Column(name = "movieId")
	private String movieId;

	@Column(name = "screenId")
	private String screenId;

	@Column(name = "showTiming")
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

	public ShowsEntity() {
		this.showId = UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", dateId=" + dateId + ", movieId=" + movieId + ", screenId=" + screenId
				+ ", showTiming=" + showTiming + "]";
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

}
