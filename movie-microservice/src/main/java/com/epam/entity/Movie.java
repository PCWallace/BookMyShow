package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "movie")
public class Movie {
	@Id
	private String movieId;

	@Column(name = "movieName")
	@NotNull
	private String movieName;

	@Column(name = "movieDescription")
	@NotNull
	private String movieDescription;

	@Column(name = "active")
	@NotNull
	private int active;

	@Column(name = "movieGenres")
	@NotNull
	private String movieGenres;

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", active=" + active + ", movieGenres=" + movieGenres + "]";
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	public Movie() {
		this.movieId = UUID.randomUUID().toString();
	}
}
