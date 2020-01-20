package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.MovieRequestDto;
import com.epam.dto.MovieResponseDto;
import com.epam.mapper.MovieMapper;
import com.epam.repository.MovieRepository;
import com.epam.service.MovieServices;

@Service
public class MoviesServicesImpl implements MovieServices {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieResponseDto> getAll() {
		return MovieMapper.MAPPER.toMovieDtos((movieRepository.findAll()));
	}

	@Override
	public MovieResponseDto getMovieById(String movieId) throws SQLException {
		MovieResponseDto movie = MovieMapper.MAPPER.toMovieDto(movieRepository.findByMovieId(movieId));
		if (movie == null)
			throw new SQLException();
		return movie;
	}

	@Override
	public MovieResponseDto insert(MovieRequestDto dto) throws SQLException {
		MovieResponseDto movie;
		try {
			movie = MovieMapper.MAPPER.toMovieDto(movieRepository.save(MovieMapper.MAPPER.toMovieEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return movie;
	}

	@Override
	public MovieResponseDto update(MovieResponseDto dto) throws SQLException {
		MovieResponseDto movie;
		try {
			movie = MovieMapper.MAPPER.toMovieDto(movieRepository.save(MovieMapper.MAPPER.toMovieEntity(dto)));

		} catch (Exception e) {
			throw new SQLException();
		}
		return movie;
	}

	@Override
	public void delete(String movieId) throws SQLException {
		try {
			movieRepository.deleteById(movieId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

}
