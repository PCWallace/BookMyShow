package com.epam.dto;

import javax.validation.constraints.NotNull;

public class TierRequestDto {

	@NotNull(message = "TierName shgould be present")
	private String tierName;

	@NotNull(message = "Screen id shgould be present")
	private String screenId;

	@NotNull(message = "Tier cost shgould be present")
	private int cost;

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
		return "TierRequestDto [tierName=" + tierName + ", screenId=" + screenId + ", cost=" + cost + "]";
	}
}
