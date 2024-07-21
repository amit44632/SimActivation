package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.CustomerAddressDto;
import com.infosys.dto.CustomerDto;
import com.infosys.dto.CustomerIdentityDto;
import com.infosys.dto.SimDetailsDto;
import com.infosys.dto.SimOffersDto;
import com.infosys.service.SimDetailsService;

@RestController
@RequestMapping("/SIM")
public class SimDetailsController {

	@Autowired
	private SimDetailsService simdetailsservice;
	
	@GetMapping("/")
	public String hello() {
		return "hello moto";
	}
	
	@PostMapping("/create_sim_details")
	public ResponseEntity<Object> create_sim_details(@RequestBody SimDetailsDto simdetailsdto){
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(simdetailsservice.create_sim_details(simdetailsdto));
	}
	
	@PostMapping("/simOffer")
	public ResponseEntity<Object> create_simOffer(@RequestBody SimOffersDto simoffersdto){
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(simdetailsservice.create_simOffer(simoffersdto));
	}
	
	@PostMapping("/create_customerAddress")
	public ResponseEntity<Object> create_customerAddress(@RequestBody CustomerAddressDto customeraddressdto ){
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(simdetailsservice.create_customerAddress(customeraddressdto));
	}
	
	@PostMapping("/create_customer_details")
	public ResponseEntity<Object> create_customer_details(@RequestBody CustomerDto customerdto){
	
		return  ResponseEntity.status(HttpStatus.CREATED).body(simdetailsservice.create_customer_details(customerdto));
	}
	@PostMapping("/create_customer_identity")
	public ResponseEntity<Object> create_customer_identity(@RequestBody CustomerIdentityDto customeridentitydto){
	
		return  ResponseEntity.status(HttpStatus.CREATED).body(simdetailsservice.create_customer_identity(customeridentitydto));
	}
}
