package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Movie;
import com.epam.repository.MovieRepository;
import com.epam.service.MovieServices;

@Service
public class MoviesServicesImpl implements MovieServices {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(String movieId) {
		return movieRepository.findByMovieId(movieId);
	}

	@Override
	public Movie insert(Movie dto) {
		return movieRepository.save(dto);
	}

	@Override
	public Movie update(String movieId) {
		Movie movie = getMovieById(movieId);
		movie.setActive(0);
		return movieRepository.save(movie);
	}

	@Override
	public Movie delete(String movieId) {
		movieRepository.deleteById(movieId);
		return getMovieById(movieId);
	}

}
