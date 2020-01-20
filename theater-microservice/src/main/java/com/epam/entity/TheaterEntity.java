package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "theater")
public class TheaterEntity {
	@Id
	private String theaterId;

	@Column(name = "cityId")
	private String cityId;

	@Column(name = "theaterName")
	private String theaterName;

	@Column(name = "theaterAddress")
	private String theaterAddress;

	@Column(name = "numberOfScreens")
	private int numberOfScreens;

	@Column(name = "active")
	private int active;

	public TheaterEntity() {
		this.theaterId = UUID.randomUUID().toString();
		this.active = 0;
		this.numberOfScreens = 0;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

	public void setNumberOfScreens(int numberOfScreens) {
		this.numberOfScreens = numberOfScreens;
	}

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", cityId=" + cityId + ", theaterName=" + theaterName
				+ ", theaterAddress=" + theaterAddress + ", numberOfScreens=" + numberOfScreens + ", active=" + active
				+ "]";
	}
}
