package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epam.entity.SeatEntity;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, String> {
	@Query(nativeQuery = true, value = "Select * FROM Screen join Tier on Screen.screenId = Tier.screenId join Seat on Tier.tierId = Seat.tierId where Screen.screenId=:screenId")
	public List<SeatEntity> findByScreenId(String screenId);
}
