package com.hcl.flightbookingservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.FlightDetailsDTO;
import com.hcl.flightbookingservice.entity.FlightDetails;
import com.hcl.flightbookingservice.repository.SearchFlightRepository;

@Service
public class SearchFlightService {
	
	@Autowired
	SearchFlightRepository searchFlightRepository;
	
	
	public void persistUser(FlightDetailsDTO flightdetailsrequest) {
		FlightDetails flightdetails = new FlightDetails();
		BeanUtils.copyProperties(flightdetailsrequest, flightdetails);
		searchFlightRepository.save(flightdetails);
	}
	
	
	
	public List<FlightDetails> searchFlightDetails(){
		
		return searchFlightRepository.findAll();
		
	}
	
public List<FlightDetails> searchFlightDetailsBasedOnFlightName(){
		
		return searchFlightRepository.findByOrderByFlightNameAsc();
					
}

public List<FlightDetails> searchFlightDetailsBasedOnAvailableSeats(){
	return searchFlightRepository.findByOrderByAvailableSeatsAsc();
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
