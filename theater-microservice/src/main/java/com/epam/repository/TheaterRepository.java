package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.TheaterEntity;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, String> {
	public TheaterEntity findByTheaterId(String theaterId);

	public List<TheaterEntity> findByCityId(String cityId);

}
