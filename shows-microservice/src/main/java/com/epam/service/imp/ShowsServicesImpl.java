package com.epam.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Shows;
import com.epam.repository.ShowsRepository;
import com.epam.service.ShowsServices;

@Service
public class ShowsServicesImpl implements ShowsServices {

	@Autowired
	private ShowsRepository showsRepository;

	@Override
	public List<Shows> getAll() {
		return showsRepository.findAll();
	}

	@Override
	public Shows getShowById(String showId) {
		return showsRepository.findByShowId(showId);
	}

	@Override
	public Shows delete(String showId) {
		showsRepository.deleteById(showId);
		return getShowById(showId);
	}

	@Override
	public List<Shows> insertAll(List<Shows> showsDto) {
		return showsRepository.saveAll(showsDto);
	}

}
