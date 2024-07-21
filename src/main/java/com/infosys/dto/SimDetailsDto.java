package com.infosys.dto;

public class SimDetailsDto {

    private long simId;
	
	private long serviceNumber;
	
	private long simNumber;
	
	private String simStatus;

	public long getSimId() {
		return simId;
	}

	public void setSimId(long simId) {
		this.simId = simId;
	}

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public long getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(long simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimStatus() {
		return simStatus;
	}

	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}

	@Override
	public String toString() {
		return "SimDetailsDto [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	
	
}
