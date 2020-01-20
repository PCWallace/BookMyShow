package com.epam.service;

import java.util.List;

import com.epam.entity.TierEntity;

public interface TierService {
	public TierEntity insert(TierEntity dto);

	public TierEntity update(TierEntity dto);

	public List<TierEntity> getAllTiers();
}
