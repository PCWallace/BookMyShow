package com.epam.service;

import java.util.List;

import com.epam.entity.Order;

public interface OrderServices {
	public List<Order> insert(List<Order> dto);

	public boolean delete(List<Order> dto);
}
