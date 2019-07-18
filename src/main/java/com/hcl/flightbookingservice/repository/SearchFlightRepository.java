package com.hcl.flightbookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.FlightDetails;

@Repository
public interface SearchFlightRepository extends JpaRepository<FlightDetails,Long> {
	
	public List<FlightDetails> findByOrderByFlightNameAsc();

	public List<FlightDetails> findByOrderByBoardingAsc();
	
	public List<FlightDetails> findByOrderByDestinationAsc();
	
	public List<FlightDetails> findByOrderByDateOfJourneyAsc();
	
	public List<FlightDetails> findByOrderByTimeOfJourneyAsc();
	
	public List<FlightDetails> findByOrderByPriceAsc();

	public List<FlightDetails> findByOrderByDurationAsc();
	
	public  FlightDetails findByflightId(String flightId );
	

}
