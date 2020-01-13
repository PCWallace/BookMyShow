package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "userplacedorders")
public class UserPlacedOrders {
	@Id
	@Column(name = "userPlacedOrdersId")
	private String userPlacedOrdersId;

	@Column(name = "userId")
	private String userId;

	@Column(name = "ticketId")
	private String ticketId;

	public UserPlacedOrders() {
		this.userPlacedOrdersId = UUID.randomUUID().toString();
	}

	public String getUserPlacedOrdersId() {
		return userPlacedOrdersId;
	}

	public void setUserPlacedOrdersId(String userPlacedOrdersId) {
		this.userPlacedOrdersId = userPlacedOrdersId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "UserPlacedOrders [userPlacedOrdersId=" + userPlacedOrdersId + ", userId=" + userId + ", ticketId="
				+ ticketId + "]";
	}

}
