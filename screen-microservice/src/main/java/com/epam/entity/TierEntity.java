package com.epam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tier")
public class TierEntity {
	@Id
	@Column(name = "tierId")
	private String tierId;

	@Column(name = "tierName")
	private String tierName;

	@Column(name = "screenId")
	private String screenId;

	@Column(name = "price")
	private int cost;

	public TierEntity() {
		this.tierId = UUID.randomUUID().toString();
	}

	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Tier [tierId=" + tierId + ", tierName=" + tierName + ", screenId=" + screenId + ", cost=" + cost + "]";
	}

}
