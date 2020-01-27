package com.epam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.ShowsEntity;

@Repository
public interface ShowsRepository extends JpaRepository<ShowsEntity, String> {
	public ShowsEntity findByShowId(String showId);

	public List<ShowsEntity> findByScreenId(String screenId);

	public List<ShowsEntity> findByMovieId(String movieId);

	public List<ShowsEntity> findByScreenIdAndDateId(String screenId, String dateId);
}
