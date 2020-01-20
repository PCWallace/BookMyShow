package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.ScreenEntity;
@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, String> {
}
