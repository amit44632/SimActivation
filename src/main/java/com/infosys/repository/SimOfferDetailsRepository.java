package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.SimOffers;

@Repository
public interface SimOfferDetailsRepository extends JpaRepository<SimOffers, Integer>{
	
	@Query(value="SELECT * FROM SIM_OFFERS where SIM_ID=?",nativeQuery=true)
	List<SimOffers> findOfferBySimId(long simId);

}
