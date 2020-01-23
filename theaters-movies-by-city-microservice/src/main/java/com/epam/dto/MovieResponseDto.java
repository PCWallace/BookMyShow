package com.epam.dto;

public class MovieResponseDto {

	private String movieId;

	private String movieName;

	private String movieDescription;

	private int active;

	private String movieGenres;

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

	@Override
	public String toString() {
		return "MovieResponseDto [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription="
				+ movieDescription + ", active=" + active + ", movieGenres=" + movieGenres + "]";
	}
}
