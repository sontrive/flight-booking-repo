package com.hcl.flightbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastTravelDetailsRepository extends JpaRepository<T, Long> {

	
}
