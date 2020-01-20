package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.DatesEntity;

@Repository
public interface DatesRepository extends JpaRepository<DatesEntity, String> {
	public DatesEntity findByDateId(String dateId);
}
