package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epam.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
	@Query(nativeQuery = true, value = "Select * FROM Screen join Tier on Screen.screenId = Tier.screenId join Seat on Tier.tierId = Seat.tierId where Screen.screenId=:screenId")
	public List<Seat> findByScreenId(String screenId);
}
