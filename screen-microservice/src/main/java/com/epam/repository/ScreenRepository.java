package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.Screen;
@Repository
public interface ScreenRepository extends JpaRepository<Screen, String> {
}
