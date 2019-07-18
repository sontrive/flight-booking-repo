package com.hcl.flightbookingservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.entity.FlightDetails;
import com.hcl.flightbookingservice.repository.SearchFlightRepository;

@Service
public class SearchFlightService {
	
	@Autowired
	SearchFlightRepository searchFlightRepository;
	
	
	
	public List<FlightDetails> searchFlightDetails(){
		
		return searchFlightRepository.findAll();
		
	}
	
public List<FlightDetails> searchFlightDetailsBasedOnFlightName(String flightName){
		
		return searchFlightRepository.findByOrderByFlightNameAsc();
					
}

public List<FlightDetails> searchFlightDetailsBasedOnBorading(String boarding){
	
	return searchFlightRepository.findByOrderByBoardingAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnDestination(String destination){
	
	return searchFlightRepository.findByOrderByDestinationAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnDateOfJourney(LocalDate localDate){
	
	return searchFlightRepository.findByOrderByDateOfJourneyAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnTimeOfJourney(LocalTime localTime){
	
	return searchFlightRepository.findByOrderByTimeOfJourneyAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnPrice(double price){
	
	return searchFlightRepository.findByOrderByPriceAsc();
				
}


public List<FlightDetails> searchFlightDetailsBasedOnDuration(double duration){
	
	return searchFlightRepository.findByOrderByDurationAsc();
				
}
	

}
