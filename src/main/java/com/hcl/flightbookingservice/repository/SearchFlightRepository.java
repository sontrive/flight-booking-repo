package com.hcl.flightbookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.FlightDetails;

@Repository
public interface SearchFlightRepository extends JpaRepository<FlightDetails,Long> {

	public Optional<List<FlightDetails>> findByBoarding(String boarding);
	
	public Optional<List<FlightDetails>> findByDestination(String destination);
	
	public Optional<List<FlightDetails>> findByDateOfJourney(String dateOfJourney);
	
	public Optional<List<FlightDetails>> findByTimeOfJourney(String timeOfJourney);
	
	public Optional<List<FlightDetails>> findByPrice(String price);

}
