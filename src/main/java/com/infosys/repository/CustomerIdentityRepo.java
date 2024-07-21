package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.CustomerIdentity;
@Repository
public interface CustomerIdentityRepo extends JpaRepository<CustomerIdentity, Long>{

}
