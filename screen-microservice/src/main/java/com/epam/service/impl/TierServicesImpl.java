package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Tier;
import com.epam.repository.TierRepository;
import com.epam.service.TierService;

@Service
public class TierServicesImpl implements TierService {

	@Autowired
	private TierRepository tierRepository;

	@Override
	public Tier insert(Tier dto) {
		return tierRepository.save(dto);
	}

	@Override
	public Tier update(Tier dto) {
		return tierRepository.save(dto);
	}

	@Override
	public List<Tier> getAllTiers() {
		return tierRepository.findAll();
	}

}
