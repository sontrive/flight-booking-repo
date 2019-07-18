package com.hcl.flightbookingservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/search")
	public ResponseEntity<?> getFlightDetails(@RequestBody FlightDetails flightdetails,String sortParam) {
		List<FlightDetails> flightDetails =null ;
		try {
			validateFields(flightdetails);
			
			if (sortParam == null ||"".equals(sortParam)) {
				List<FlightDetails> searchFlightDetails=flightDetails= searchFlightService.searchFlightDetails();
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetails,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getFlightName())){
				List<FlightDetails> searchFlightDetailsBasedOnFlightName = searchFlightService.searchFlightDetailsBasedOnFlightName(flightdetails.getFlightName());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnFlightName, HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getBoarding())){
				List<FlightDetails> searchFlightDetailsBasedOnBoarding = searchFlightService.searchFlightDetailsBasedOnBorading(flightdetails.getBoarding());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnBoarding,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getDestination())){
				List<FlightDetails> searchFlightDetailsBasedOnDestination = searchFlightService.searchFlightDetailsBasedOnDestination(flightdetails.getDestination());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnDestination,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getDateOfJourney())){
				List<FlightDetails> searchFlightDetailsBasedOnDateOfJourney = searchFlightService.searchFlightDetailsBasedOnDateOfJourney(flightdetails.getDateOfJourney());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnDateOfJourney, HttpStatus.OK);
			}
			if(sortParam.equals(flightdetails.getTimeOfJourney())){
				List<FlightDetails> searchFlightDetailsBasedOnTimeOfJourney = searchFlightService.searchFlightDetailsBasedOnTimeOfJourney(flightdetails.getTimeOfJourney());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnTimeOfJourney, HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getPrice())){
				List<FlightDetails> searchFlightDetailsBasedOnPrice = searchFlightService.searchFlightDetailsBasedOnPrice(flightdetails.getPrice());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnPrice, HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getDuration())){
				List<FlightDetails> searchFlightDetailsBasedOnDuration = searchFlightService.searchFlightDetailsBasedOnDuration(flightdetails.getDuration());
				return new ResponseEntity<List<FlightDetails>>(searchFlightDetailsBasedOnDuration, HttpStatus.OK);
			}
			
		}
		catch(ApplicationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<List<FlightDetails>>(flightDetails, HttpStatus.OK);
		
	}
	
	
	private void validateFields(FlightDetails flightDetails) throws ApplicationException{
		
		if((flightDetails.getBoarding()==null) || "".equals(flightDetails.getBoarding())){
			throw new ApplicationException("Invalid Boarding Details");
		}
		
		if((flightDetails.getDestination()==null) || "".equals(flightDetails.getDestination())){
			throw new ApplicationException("Invalid Destination Details");
		}
		
		if((flightDetails.getDateOfJourney()==null) || "".equals(flightDetails.getDateOfJourney())){
			throw new ApplicationException("Invalid Date of Journey Details");
		}
		
		if((flightDetails.getTimeOfJourney()==null) || "".equals(flightDetails.getTimeOfJourney())){
			throw new ApplicationException("Invalid Time of Journey Details");
		}
	}
		
		
		
}

