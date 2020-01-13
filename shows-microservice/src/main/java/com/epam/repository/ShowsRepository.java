package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.Shows;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, String> {
	public Shows findByShowId(String showId);
}
