package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.TierEntity;

@Repository
public interface TierRepository extends JpaRepository<TierEntity, String> {
	public TierEntity findByTierId(String tierId);

	public List<TierEntity> findByScreenId(String screenId);
}
