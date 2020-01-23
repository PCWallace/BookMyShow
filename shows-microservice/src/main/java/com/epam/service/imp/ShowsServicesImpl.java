package com.epam.service.imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.ShowRequestDto;
import com.epam.dto.ShowResponseDto;
import com.epam.mapper.ShowMapper;
import com.epam.repository.ShowsRepository;
import com.epam.service.ShowsServices;

@Service
public class ShowsServicesImpl implements ShowsServices {

	@Autowired
	private ShowsRepository showsRepository;

	@Override
	public List<ShowResponseDto> getAll() {
		return ShowMapper.MAPPER.toShowDtos(showsRepository.findAll());
	}
	
	@Override
	public List<ShowResponseDto> getAllShowsByScreenId(String screenId) {
		return ShowMapper.MAPPER.toShowDtos(showsRepository.findByScreenId(screenId));
	}

	@Override
	public ShowResponseDto getShowById(String showId) throws SQLException {
		ShowResponseDto show = ShowMapper.MAPPER.toShowDto(showsRepository.findByShowId(showId));
		if (show == null)
			throw new SQLException();
		return show;
	}

	@Override
	public void delete(String showId) throws SQLException {
		try {
			showsRepository.deleteById(showId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public List<ShowResponseDto> insertAll(List<ShowRequestDto> showsDto) throws SQLException {
		List<ShowResponseDto> shows;
		try {
			shows = ShowMapper.MAPPER
					.toShowDtos(showsRepository.saveAll(ShowMapper.MAPPER.toRegisterShowEntity(showsDto)));
		} catch (Exception e) {
			throw new SQLException();
		}
		return shows;
	}

}
