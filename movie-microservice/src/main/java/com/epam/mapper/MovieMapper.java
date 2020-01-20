package com.epam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.dto.MovieRequestDto;
import com.epam.dto.MovieResponseDto;
import com.epam.entity.MovieEntity;

@Mapper
public interface MovieMapper {
	MovieResponseDto toMovieDto(MovieEntity movie);

	List<MovieEntity> toRegisterMovieEntity(List<MovieRequestDto> movieDtoList);

	MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);

	List<MovieResponseDto> toMovieDtos(List<MovieEntity> movieEntityList);

	MovieEntity toMovieEntity(MovieResponseDto movie);

	MovieEntity toMovieEntity(MovieRequestDto movie);
}
