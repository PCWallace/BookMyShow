package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Order;
import com.epam.service.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	private OrderServices orders;

	@RequestMapping(method = RequestMethod.POST, value = "/order",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> insertOrders(@RequestBody List<Order> dto) {
		return orders.insert(dto);
	}
}
