package com.infosys.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.CustomerAddressDto;
import com.infosys.dto.CustomerDto;
import com.infosys.dto.CustomerIdentityDto;
import com.infosys.service.SimDetailsService;
@Validated
@RestController
@RequestMapping("/Sim_Activation")
public class SimActivationProcess {

	@Autowired
	private SimDetailsService simdetailsservice;
	
	
	
	@GetMapping("/simValidation")
	public ResponseEntity<Object> simValidation(@Valid @RequestParam("simId") String simId,@RequestParam("service_num") String service_num) {
		
	return ResponseEntity.status(HttpStatus.OK).body(simdetailsservice.simValidation(simId,service_num));
	}    
	
	@GetMapping("/createCustomerBasicsDetails")
	public ResponseEntity<Object> createCustomerBasicsDetails(@Valid @RequestParam("email") String email,@RequestParam("dob")  @DateTimeFormat(pattern="yyyy-MM-dd") Date dob) {
		
		return ResponseEntity.status(HttpStatus.OK).body(simdetailsservice.createCustomerBasicsDetails(dob,email));
	}   
	
	@GetMapping("/customerPersonalDetails/{emailid}")
	public ResponseEntity<Object> createCustomerPersonalDetails(@PathVariable("emailid") String emailId ,@RequestParam("first_name")String first_name, @RequestParam("last_name") String last_name) {
		
	return ResponseEntity.status(HttpStatus.OK).body(simdetailsservice.createCustomerPersonalDetails(emailId,first_name,last_name));
	}
	
	@PutMapping("/customers/{address_id}")
	public ResponseEntity<Object> updateCustomerAddress(@Valid @PathVariable("address_id") Integer address_id ,@RequestBody CustomerAddressDto customeraddressdto) {
		
	return ResponseEntity.status(HttpStatus.OK).body(simdetailsservice.updateCustomerAddress(address_id,customeraddressdto));
	}
	
	@PutMapping("/customer/{uniqueIdNumber}")
	public ResponseEntity<Object> createCustomerProofValidation(@PathVariable("uniqueIdNumber") Long uniqueIdNumber ,@RequestBody CustomerDto customerdto) {
		
		return ResponseEntity.status(HttpStatus.OK).body(simdetailsservice.createCustomerProofValidation(uniqueIdNumber,customerdto));
		}
	
	
	
	
	
	
	
}
