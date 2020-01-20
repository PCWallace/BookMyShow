package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.MovieRequestDto;
import com.epam.dto.MovieResponseDto;

public interface MovieServices {
	public List<MovieResponseDto> getAll();

	public MovieResponseDto getMovieById(String movieId) throws SQLException;

	public MovieResponseDto insert(MovieRequestDto dto) throws SQLException;

	public MovieResponseDto update(MovieResponseDto dto) throws SQLException;

	public void delete(String movieId) throws SQLException;
}
