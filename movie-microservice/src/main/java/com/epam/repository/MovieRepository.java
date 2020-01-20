package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {
	public MovieEntity findByMovieId(String movieId);

}
