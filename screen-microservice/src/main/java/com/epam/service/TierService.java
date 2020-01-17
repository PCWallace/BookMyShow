package com.epam.service;

import java.util.List;

import com.epam.entity.Tier;

public interface TierService {
	public Tier insert(Tier dto);

	public Tier update(Tier dto);

	public List<Tier> getAllTiers();
}
