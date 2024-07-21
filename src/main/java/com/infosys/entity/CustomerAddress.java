package com.infosys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer addressId;
	
	private String address;
	
	private String city;
	
	private long pincode;
	
	private String state;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}
	
	
	
}
