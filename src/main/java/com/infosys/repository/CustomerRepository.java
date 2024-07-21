package com.infosys.repository;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(value="Select * from CUSTOMER where DATE_OFBIRTH=? and EMAIL_ADDRESS=?",nativeQuery=true)
	List<Customer> findByEmailAndDOB(Date dob, @Valid String email);

	@Query(value="Select * from CUSTOMER where EMAIL_ADDRESS=?",nativeQuery=true)
	List<Customer> findByEmailId(String emailId);

	@Query(value="Select * from CUSTOMER where FIRST_NAME=? and LAST_NAME =?",nativeQuery=true)
	List<Customer> findByFirstAndLastName(String first_name, String last_name);


}
