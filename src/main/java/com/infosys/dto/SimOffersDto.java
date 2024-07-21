package com.infosys.dto;

public class SimOffersDto {
	
    private Integer offerId;
	
	private long callQty;
	
	private Integer cost;
	
	private Integer dataQty;
	
	private long duration;
	
	private String offerName;
	
	private long simId;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public long getCallQty() {
		return callQty;
	}

	public void setCallQty(long callQty) {
		this.callQty = callQty;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getDataQty() {
		return dataQty;
	}

	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public long getSimId() {
		return simId;
	}

	public void setSimId(long simId) {
		this.simId = simId;
	}

	@Override
	public String toString() {
		return "SimOffersDto [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simId=" + simId + "]";
	}

	

}
