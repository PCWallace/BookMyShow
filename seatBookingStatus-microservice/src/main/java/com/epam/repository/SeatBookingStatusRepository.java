package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.SeatBookingStatus;

@Repository
public interface SeatBookingStatusRepository extends JpaRepository<SeatBookingStatus, String> {
	public List<SeatBookingStatus> findByShowId(String showId);

	public SeatBookingStatus findByShowIdAndSeatId(String showId, String seatId);

}
