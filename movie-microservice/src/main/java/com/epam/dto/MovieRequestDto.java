package com.epam.dto;

import javax.validation.constraints.NotNull;

public class MovieRequestDto {

	@NotNull(message = "Movie Name shgould be present")
	private String movieName;

	@NotNull(message = "Movie description shgould be present")
	private String movieDescription;

	@NotNull(message = "Movie genre shgould be present")
	private String movieGenres;

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

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	@Override
	public String toString() {
		return "MovieRequestDto [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieGenres="
				+ movieGenres + "]";
	}
}
