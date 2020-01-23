package com.epam.model;

import java.util.List;

import com.epam.dto.MovieResponseDto;
import com.epam.dto.TheaterResponseDto;

public class TheatersMovies {
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
