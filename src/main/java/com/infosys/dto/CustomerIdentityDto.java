package com.infosys.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerIdentityDto {

    private long uniqueIdNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfbirth;
	
	private String firstName;
	
	private String lastNumber;
	
	private String emailAddress;
	
	private String state;

	public long getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(long uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(String lastNumber) {
		this.lastNumber = lastNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CustomerIdentityDto [uniqueIdNumber=" + uniqueIdNumber + ", dateOfbirth=" + dateOfbirth + ", firstName="
				+ firstName + ", lastNumber=" + lastNumber + ", emailAddress=" + emailAddress + ", state=" + state
				+ "]";
	}
	
	
}
