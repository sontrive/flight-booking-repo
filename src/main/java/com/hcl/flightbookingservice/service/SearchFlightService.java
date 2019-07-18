package com.hcl.flightbookingservice.service;

import java.util.List;

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
	
public List<FlightDetails> searchFlightDetailsBasedOnFlightName(){
		
		return searchFlightRepository.findByOrderByFlightNameAsc();
					
}

public List<FlightDetails> searchFlightDetailsBasedOnBorading(){
	
	return searchFlightRepository.findByOrderByBoardingAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnDestination(){
	
	return searchFlightRepository.findByOrderByDestinationAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnDateOfJourney(){
	
	return searchFlightRepository.findByOrderByDateOfJourneyAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnTimeOfJourney(){
	
	return searchFlightRepository.findByOrderByTimeOfJourneyAsc();
				
}

public List<FlightDetails> searchFlightDetailsBasedOnPrice(){
	
	return searchFlightRepository.findByOrderByPriceAsc();
				
}


public List<FlightDetails> searchFlightDetailsBasedOnDuration(){
	
	return searchFlightRepository.findByOrderByDurationAsc();
				
}
	

}
