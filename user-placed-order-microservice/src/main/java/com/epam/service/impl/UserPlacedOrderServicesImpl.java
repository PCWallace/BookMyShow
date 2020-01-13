package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.UserPlacedOrders;
import com.epam.repository.UserPlacedOrderRepository;
import com.epam.service.UserPlacedOrderServices;

@Service
public class UserPlacedOrderServicesImpl implements UserPlacedOrderServices {

	@Autowired
	private UserPlacedOrderRepository userPlacedOrderRepository;

	@Override
	public List<UserPlacedOrders> getAllPlacedByUser(String userId) {
		return userPlacedOrderRepository.findByUserId(userId);
	}

	@Override
	public UserPlacedOrders insertPlacedOrder(UserPlacedOrders dto) {
		return userPlacedOrderRepository.save(dto);
	}

}
