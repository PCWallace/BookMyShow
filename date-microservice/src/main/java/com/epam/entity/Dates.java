package com.epam.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@Table(name = "dates")
public class Dates {
	@Id
	private String dateId;

	@Column(name = "dateOfShows")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfShows;

	public Dates() {
		this.dateId = UUID.randomUUID().toString();
	}

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public Date getDateOfShows() {
		return dateOfShows;
	}

	public void setDateOfShows(Date dateOfShows) {
		this.dateOfShows = dateOfShows;
	}

	@Override
	public String toString() {
		return "Dates [dateId=" + dateId + ", dateOfShows=" + dateOfShows + "]";
	}
	
}
