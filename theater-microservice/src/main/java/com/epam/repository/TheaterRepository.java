package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String> {
	public Theater findByTheaterId(String theaterId);

}
