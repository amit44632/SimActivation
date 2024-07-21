package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.SimDetails;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails, Long>{
	
	@Query(value="Select * from SIM_DETAILS where SIM_NUMBER=? and SERVICE_NUMBER=?", nativeQuery=true)
	List<SimDetails> findBySimIdAndServiceNum(String simId, String service_num);


}
