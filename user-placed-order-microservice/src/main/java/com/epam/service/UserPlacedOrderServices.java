package com.epam.service;

import java.util.List;

import com.epam.entity.UserPlacedOrders;

public interface UserPlacedOrderServices {
 public List<UserPlacedOrders> getAllPlacedByUser(String userId);
 
 public UserPlacedOrders insertPlacedOrder(UserPlacedOrders dto);
}
