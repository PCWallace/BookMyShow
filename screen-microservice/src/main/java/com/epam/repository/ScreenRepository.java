package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.ScreenEntity;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, String> {
	public ScreenEntity findByScreenId(String screenId);

	public List<ScreenEntity> findByTheaterId(String theaterId);
}
