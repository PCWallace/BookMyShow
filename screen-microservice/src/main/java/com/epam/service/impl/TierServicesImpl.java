package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.TierEntity;
import com.epam.repository.TierRepository;
import com.epam.service.TierService;

@Service
public class TierServicesImpl implements TierService {

	@Autowired
	private TierRepository tierRepository;

	@Override
	public TierEntity insert(TierEntity dto) {
		return tierRepository.save(dto);
	}

	@Override
	public TierEntity update(TierEntity dto) {
		return tierRepository.save(dto);
	}

	@Override
	public List<TierEntity> getAllTiers() {
		return tierRepository.findAll();
	}

}
