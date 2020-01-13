package com.epam.service;

import java.util.List;

import com.epam.entity.Movie;

public interface MovieServices {
	public List<Movie> getAll();

	public Movie getMovieById(String movieId);

	public Movie insert(Movie dto);

	public Movie update(String movieId);

	public Movie delete(String movieId);
}
