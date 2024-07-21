package com.infosys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long uniqueIdNumber;
    
    private LocalDate dateOfbirth;
    
    private String emailAddress;
    
    private String firstName;
    
    private String lastName;
    
    private String idType;
    
    //@ManyToOne
   // @JoinColumn(name="ADDRESS_ID" ,referencedColumnName = "addressId")
  //  private CustomerAddress customerAddress_add;
    private Integer customerAdd_Id;
    
    private Integer ressId;
    
    private long simId;
    
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Integer getCustomerAdd_Id() {
		return customerAdd_Id;
	}

	public void setCustomerAdd_Id(Integer customerAdd_Id) {
		this.customerAdd_Id = customerAdd_Id;
	}

	public Integer getRessId() {
		return ressId;
	}

	public void setRessId(Integer ressId) {
		this.ressId = ressId;
	}

	public long getSimId() {
		return simId;
	}

	public void setSimId(long simId) {
		this.simId = simId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfbirth=" + dateOfbirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", customerAdd_Id=" + customerAdd_Id + ", ressId=" + ressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}

	
	
}
