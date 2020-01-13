package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, String> {
	public Dates findByDateId(String dateId);
}
