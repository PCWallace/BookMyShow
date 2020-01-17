package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, String> {
	public CityEntity findByCityId(String cityId);
}
