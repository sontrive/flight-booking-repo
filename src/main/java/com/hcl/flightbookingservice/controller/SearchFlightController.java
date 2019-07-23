package com.hcl.flightbookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.FlightDetailsDTO;
import com.hcl.flightbookingservice.entity.FlightDetails;
import com.hcl.flightbookingservice.exception.ApplicationException;
import com.hcl.flightbookingservice.service.SearchFlightService;


/*
 * This is the SearchFlightController to perform search for flights
 */


@RestController
@RequestMapping("/searchflight")
public class SearchFlightController {
	
	@Autowired
	SearchFlightService searchFlightService;
	
	
	
	/*
	 * This method is used to search the flight
	 * @RequestBody gets flight details request
	 * @return return the response
	 */
	
	@PostMapping("/")
	public ResponseEntity<Object> getFlightDetails(@RequestBody FlightDetailsDTO flightdetailsrequest,String sortParam) {

		List<FlightDetails> flightDetails =null ;
		try {
			validateFields(flightdetailsrequest);
			
			if (sortParam == null ||"".equals(sortParam)) {
				List<FlightDetails> searchFlightDetails=searchFlightService.searchFlightDetails();
				return new ResponseEntity<>(searchFlightDetails,HttpStatus.OK);
			}
			
			if(sortParam.equalsIgnoreCase("flightname")){
				List<FlightDetails> searchFlightDetailsBasedOnFlightName = searchFlightService.searchFlightDetailsBasedOnFlightName();
				return new ResponseEntity<>(searchFlightDetailsBasedOnFlightName, HttpStatus.OK);
			}

			if(sortParam.equalsIgnoreCase("dateofjourney")){
				List<FlightDetails> searchFlightDetailsBasedOnDateOfJourney = searchFlightService.searchFlightDetailsBasedOnDateOfJourney();
				return new ResponseEntity<>(searchFlightDetailsBasedOnDateOfJourney, HttpStatus.OK);
			}
			if(sortParam.equalsIgnoreCase("timeofjourney")){
				List<FlightDetails> searchFlightDetailsBasedOnTimeOfJourney = searchFlightService.searchFlightDetailsBasedOnTimeOfJourney();
				return new ResponseEntity<>(searchFlightDetailsBasedOnTimeOfJourney, HttpStatus.OK);
			}
			
			if(sortParam.equalsIgnoreCase("price")){
				List<FlightDetails> searchFlightDetailsBasedOnPrice = searchFlightService.searchFlightDetailsBasedOnPrice();
				return new ResponseEntity<>(searchFlightDetailsBasedOnPrice, HttpStatus.OK);
			}
			
			if(sortParam.equalsIgnoreCase("duration")){
				List<FlightDetails> searchFlightDetailsBasedOnDuration = searchFlightService.searchFlightDetailsBasedOnDuration();
				return new ResponseEntity<>(searchFlightDetailsBasedOnDuration, HttpStatus.OK);
			
			}
			if(sortParam.equalsIgnoreCase("availableseats")){
				List<FlightDetails> searchFlightDetailsBasedOnAvailableSeats = searchFlightService.searchFlightDetailsBasedOnAvailableSeats();
				return new ResponseEntity<>(searchFlightDetailsBasedOnAvailableSeats, HttpStatus.OK);
			}
			
		
		}
		catch(ApplicationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(flightDetails, HttpStatus.OK);
		
	}
	
	
	private void validateFields(FlightDetailsDTO flightDetailsrequest) throws ApplicationException{
		
		if((flightDetailsrequest.getBoarding()==null) || "".equals(flightDetailsrequest.getBoarding())){
			throw new ApplicationException("Invalid Boarding Details");
		}
	
		if((flightDetailsrequest.getDestination()==null) || "".equals(flightDetailsrequest.getDestination())){
			throw new ApplicationException("Invalid Destination Details");
		}
		
		if((flightDetailsrequest.getDateOfJourney()==null) || "".equals(flightDetailsrequest.getDateOfJourney().toString())){
			throw new ApplicationException("Invalid Date of Journey Details");
		}
		
		if((flightDetailsrequest.getTimeOfJourney()==null) || "".equals(flightDetailsrequest.getTimeOfJourney().toString())){
			throw new ApplicationException("Invalid Time of Journey Details");
		}
		
	}
		
		

}

