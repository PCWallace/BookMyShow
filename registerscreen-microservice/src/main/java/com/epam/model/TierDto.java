package com.epam.model;

import org.springframework.lang.NonNull;

public class TierDto {

	@NonNull
	private String tierName;

	@NonNull
	private String screenId;

	@NonNull
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public TierDto() {

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

	@Override
	public String toString() {
		return "TierDto [tierName=" + tierName + ", screenId=" + screenId + ", cost=" + cost + "]";
	}

}
