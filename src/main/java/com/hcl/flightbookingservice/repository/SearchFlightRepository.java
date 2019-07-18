package com.hcl.flightbookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.FlightDetails;

@Repository
public interface SearchFlightRepository extends JpaRepository<FlightDetails,Long> {
	
	public Optional<List<FlightDetails>> findByOrderByFlightNameAsc();

	public Optional<List<FlightDetails>> findByOrderByBoardingAsc();
	
	public Optional<List<FlightDetails>> findByOrderByDestinationAsc();
	
	public Optional<List<FlightDetails>> findByOrderByDateOfJourneyAsc();
	
	public Optional<List<FlightDetails>> findByOrderByTimeOfJourneyAsc();
	
	public Optional<List<FlightDetails>> findByOrderByPriceAsc();

	public Optional<List<FlightDetails>> findByOrderByDurationAsc();

}
