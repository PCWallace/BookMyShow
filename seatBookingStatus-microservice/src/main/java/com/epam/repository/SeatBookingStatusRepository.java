package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.SeatBookingStatusEntity;

@Repository
public interface SeatBookingStatusRepository extends JpaRepository<SeatBookingStatusEntity, String> {
	public List<SeatBookingStatusEntity> findByShowId(String showId);

	public SeatBookingStatusEntity findByShowIdAndSeatId(String showId, String seatId);
	
	public SeatBookingStatusEntity findBySeatBookingStatusId(String seatBookingStatusId);

}
