package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	public Movie findByMovieId(String movieId);

}
