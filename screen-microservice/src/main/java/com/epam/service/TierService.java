package com.epam.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.dto.TierRequestDto;
import com.epam.dto.TierResponseDto;

public interface TierService {
	public TierResponseDto insert(TierRequestDto dto) throws SQLException;

	public TierResponseDto update(TierResponseDto dto) throws SQLException;

	public List<TierResponseDto> getAllTiers();

	TierResponseDto getTierByTierId(String tierId) throws SQLException;
}
