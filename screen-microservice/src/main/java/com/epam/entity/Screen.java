package com.epam.entity;

import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "screen")
public class Screen {
	@Id
	@Column(name = "screenId")
	private String screenId;

	@Column(name = "theaterId")
	private String theaterId;

	@Column(name = "screenName")
	private String screenName;

	public Screen() {
		this.screenId = UUID.randomUUID().toString();
	}

	public String getScreenId() {
		return screenId;
	}

	/*
	 * public void setScreenId(String screenId) { this.screenId = screenId; }
	 */

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName + "]";
	}

}
