package com.epam.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TheatersMoviesDto {
	List<TheaterResponseDto> theaters;
	List<MovieResponseDto> movies;

	public List<TheaterResponseDto> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<TheaterResponseDto> theaters) {
		this.theaters = theaters;
	}

	public List<MovieResponseDto> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieResponseDto> movies) {
		this.movies = movies;
	}
}
