package com.epam.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.TierRequestDto;
import com.epam.dto.TierResponseDto;
import com.epam.mapper.TierMapper;
import com.epam.repository.TierRepository;
import com.epam.service.TierService;

@Service
public class TierServicesImpl implements TierService {

	@Autowired
	private TierRepository tierRepository;

	@Override
	public TierResponseDto insert(TierRequestDto dto) throws SQLException {
		TierResponseDto tier;
		try {
			tier = TierMapper.MAPPER.toTierDto(tierRepository.save(TierMapper.MAPPER.toTierEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return tier;
	}

	@Override
	public TierResponseDto update(TierResponseDto dto) throws SQLException {
		TierResponseDto tier;
		try {
			tier = TierMapper.MAPPER
					.toTierDto(tierRepository.save(TierMapper.MAPPER.toTierEntity(dto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return tier;
	}

	@Override
	public List<TierResponseDto> getAllTiers() {
		return TierMapper.MAPPER.toTierDtos(tierRepository.findAll());
	}
	
	@Override
	public TierResponseDto getTierByTierId(String tierId) throws SQLException {
		TierResponseDto tier = TierMapper.MAPPER.toTierDto(tierRepository.findByTierId(tierId));
		if (tier == null)
			throw new SQLException();
		return tier;
	}

}
