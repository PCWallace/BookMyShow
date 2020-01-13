package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Order;
import com.epam.repository.OrderRepository;
import com.epam.service.OrderServices;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> insert(List<Order> dto) {
		return orderRepository.saveAll(dto);
	}

	@Override
	public boolean delete(List<Order> dto) {
		orderRepository.deleteAll(dto);
		return true;
	}

}
