package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.User;
import com.epam.entity.UserPlacedOrders;
import com.epam.service.UserPlacedOrderServices;

@RestController
@RequestMapping(value = "/placedOrders")
public class UserPlacedrestController {

	@Autowired
	private UserPlacedOrderServices userPlacedOrders;
	@RequestMapping(method = RequestMethod.POST, value = "/placed", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserPlacedOrders insertOrders(@RequestBody UserPlacedOrders dto) {
		return userPlacedOrders.insertPlacedOrder(dto);
	}
	
	@GetMapping(value = "/byUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<UserPlacedOrders> getAllPlacedOrderByUserId(@RequestBody User user){
		return userPlacedOrders.getAllPlacedByUser(user.getUserId());
	}
}
