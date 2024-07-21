package com.infosys.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.CustomerAddressDto;
import com.infosys.dto.CustomerDto;
import com.infosys.dto.CustomerIdentityDto;
import com.infosys.dto.SimDetailsDto;
import com.infosys.dto.SimOffersDto;
import com.infosys.entity.Customer;
import com.infosys.entity.CustomerAddress;
import com.infosys.entity.CustomerIdentity;
import com.infosys.entity.SimDetails;
import com.infosys.entity.SimOffers;
import com.infosys.repository.CustomerAddressRepository;
import com.infosys.repository.CustomerIdentityRepo;
import com.infosys.repository.CustomerRepository;
import com.infosys.repository.SimDetailsRepository;
import com.infosys.repository.SimOfferDetailsRepository;

@Service
public class SimDetailsService {

	@Autowired
	private SimDetailsRepository simdetailsrepository;
	
	@Autowired
	private SimOfferDetailsRepository simofferdetailsrepository;
	
	@Autowired
	private CustomerAddressRepository customeraddressrepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private CustomerIdentityRepo customeridentityrepo;
	
	public Object create_sim_details(SimDetailsDto simdetailsdto) {

		SimDetails sim= new SimDetails();
		
		sim.setSimId(simdetailsdto.getSimId());
		sim.setServiceNumber(simdetailsdto.getServiceNumber());
		sim.setSimNumber(simdetailsdto.getSimNumber());
		sim.setSimStatus(simdetailsdto.getSimStatus());
	
		SimDetails sm=	simdetailsrepository.save(sim);
		
		return "Sim Details Created Successfully."+sm.getSimNumber();
	}

	public Object create_simOffer(SimOffersDto simoffersdto) {

		SimOffers sim_offer= new SimOffers();

		sim_offer.setOfferId(simoffersdto.getOfferId());
		sim_offer.setCallQty(simoffersdto.getCallQty());
		sim_offer.setCost(simoffersdto.getCost());
		sim_offer.setDataQty(simoffersdto.getDataQty());
		sim_offer.setOfferName(simoffersdto.getOfferName());
		sim_offer.setSimId(simoffersdto.getSimId());
		sim_offer.setDuration(simoffersdto.getDuration());
		//SimOffers so=
				simofferdetailsrepository.save(sim_offer);
		
		return "Sim Offer created Successfully.";
	}

	public Object create_customerAddress(CustomerAddressDto customeraddressdto) {
		
		CustomerAddress address= new CustomerAddress();
		
		address.setAddressId(customeraddressdto.getAddressId());
		address.setAddress(customeraddressdto.getAddress());
		address.setCity(customeraddressdto.getCity());
		address.setPincode(customeraddressdto.getPincode());
		address.setState(customeraddressdto.getState());
		
		customeraddressrepository.save(address);
		
		return "Customer Address created Successfully.";
	}

	public Object create_customer_details(CustomerDto customerdto) {
		
		Customer custo= new Customer();
		
		custo.setUniqueIdNumber(customerdto.getUniqueIdNumber());
		custo.setDateOfbirth(LocalDate.from(customerdto.getDateOfbirth()));
		custo.setEmailAddress(customerdto.getEmailAddress());
		custo.setFirstName(customerdto.getFirstName());
		custo.setLastName(customerdto.getLastName());
		custo.setIdType(customerdto.getIdType());
		custo.setCustomerAdd_Id(customerdto.getCustomerAdd_Id());
		custo.setSimId(customerdto.getSimId());
		custo.setState(customerdto.getState());
		custo.setRessId(customerdto.getRessId());
		customerrepository.save(custo);
		
		return "Customer details created successfully.";
	}

	public Object create_customer_identity(CustomerIdentityDto customeridentitydto) {
	    
		CustomerIdentity identity= new CustomerIdentity();
		
		identity.setUniqueIdNumber(customeridentitydto.getUniqueIdNumber());
		identity.setDateOfbirth(LocalDate.from(customeridentitydto.getDateOfbirth()));
		identity.setFirstName(customeridentitydto.getFirstName());
		identity.setLastNumber(customeridentitydto.getLastNumber());
		identity.setEmailAddress(customeridentitydto.getEmailAddress());
		identity.setState(customeridentitydto.getState());
		
		customeridentityrepo.save(identity);
		   
		return "Customer Identity Created Successfully.";
	}

	public ResponseEntity<Object> simValidation(String simId, String service_num) {
		
		List<SimDetails> sim=simdetailsrepository.findBySimIdAndServiceNum(simId,service_num);
		
		if(sim.size()>0 && sim.get(0).getSimStatus().equals("inactive")) {
			List<SimOffers> simOffer=simofferdetailsrepository.findOfferBySimId(sim.get(0).getSimId());
			SimOffersDto dto= new SimOffersDto();
			for(int i=0;i<simOffer.size();i++) {
				dto.setOfferName(simOffer.get(i).getOfferName());	
				dto.setSimId(simOffer.get(i).getSimId());
				dto.setOfferId(simOffer.get(i).getOfferId());
				dto.setDuration(simOffer.get(i).getDuration());
				dto.setDataQty(simOffer.get(i).getDataQty());
				dto.setCost(simOffer.get(i).getCost());
				dto.setCallQty(simOffer.get(i).getCallQty());
				
			}
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		    }else {
			if(sim.size()>0 && sim.get(0).getSimStatus().equals("active")) {
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Sim Already Active");
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong !!!. Please check the Sim number And Service Number");	
			}
			
		}
		
	}

	public Object createCustomerBasicsDetails(Date dob, @Valid String email) {
		
		List<Customer> customer=customerrepository.findByEmailAndDOB(dob,email);
		if(customer.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body("Customer Validated Successfully.");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found against this customer.");		
		}
		
	
	}

	public Object createCustomerPersonalDetails(@Valid String emailId, String first_name, String last_name) {
		System.out.println(emailId);
		List<Customer> email_validation = customerrepository.findByEmailId(emailId);
		
		System.out.println("1............."+email_validation.size());
		if(email_validation.size()>0 && emailId.equals(email_validation.get(0).getEmailAddress())) {
			System.out.println("2.............");
			List<Customer> data = customerrepository.findByFirstAndLastName(first_name,last_name);
			if(data.size()>0) {
				System.out.println("3.............");
				return ResponseEntity.status(HttpStatus.OK).body("Success..Customer validated..");
			}else {
				System.out.println("4.............");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Customer found for provided details.");
			}
		}else {
			System.out.println("5.............");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Both Email and Confirm Email are not Matching.");
		}
		
	}

	public Object updateCustomerAddress(@Valid Integer address_id, CustomerAddressDto customeraddressdto) {
		
	        Optional<CustomerAddress> address=customeraddressrepository.findById(address_id);
	        if(address.isPresent()) {
	        	CustomerAddress add=address.get();
	        	add.setAddressId(address_id);
	        	add.setAddress(customeraddressdto.getAddress());
	        	add.setCity(customeraddressdto.getCity());
	        	add.setPincode(customeraddressdto.getPincode());
	        	add.setState(customeraddressdto.getState());
	        	
	        	customeraddressrepository.saveAndFlush(add);	
	        	return ResponseEntity.status(HttpStatus.OK).body("Updated new Address:"+add.getAddressId());
	        }else {
	        	CustomerAddress add=new CustomerAddress();
	        	add.setAddressId(address_id);
	        	add.setAddress(customeraddressdto.getAddress());
	        	add.setCity(customeraddressdto.getCity());
	        	add.setPincode(customeraddressdto.getPincode());
	        	add.setState(customeraddressdto.getState());
	        	
	        	customeraddressrepository.save(add);
	        	return ResponseEntity.status(HttpStatus.OK).body("Address inserted successfully with Id:"+add.getAddressId());
	        }
		
		
	}

	public Object createCustomerProofValidation(@Valid Long uniqueIdNumber,
			CustomerDto customerdto) {
		// TODO Auto-generated method stub
		boolean Id=false,first=false,last=false,dateOfBirth=false;
	   Optional<Customer> custIdentity=customerrepository.findById(uniqueIdNumber);
	   System.out.println(custIdentity.get().getFirstName()+"=="+customerdto.getFirstName());
	   if(custIdentity.isPresent()) {
		   if(custIdentity.get().getIdType().equals(customerdto.getIdType())) {
			   Id=true;
		   } 
		   if(custIdentity.get().getFirstName().equals(customerdto.getFirstName())) {
			   first=true;
		   } 
		   if(custIdentity.get().getLastName().equals(customerdto.getLastName())) {
			   last=true;
		   } 
		   if(custIdentity.get().getDateOfbirth().equals(customerdto.getDateOfbirth())) {
			   dateOfBirth=true;
		   }
	   }
		if(Id==false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id is not matching with Stored data.");
		}
		if(first==false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name is not matching with Stored data.");
		}
		if(last==false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Last Name is not matching with Stored data.");
		}
		if(dateOfBirth==false) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DOB is not matching with Stored data.");
		}
			
		 if(Id==true && first==true && last==true && dateOfBirth==true) {
			 
		Optional<SimDetails> simdetailss =simdetailsrepository.findById(customerdto.getSimId());
		
		SimDetails sim=simdetailss.get();
		sim.setSimId(customerdto.getSimId());
		sim.setSimStatus("active");
		simdetailsrepository.save(sim);
				}
		 return ResponseEntity.status(HttpStatus.OK).body("Sim Activated Successfully.");
	}

}

	
	


