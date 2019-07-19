package com.hcl.flightbookingservice.controller;

import java.util.List;

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
	public ResponseEntity<Object> getFlightDetails(@RequestBody FlightDetails flightdetails,String sortParam) {
		List<FlightDetails> flightDetails =null ;
		try {
			validateFields(flightdetails);
			
			if (sortParam == null ||"".equals(sortParam)) {
				List<FlightDetails> searchFlightDetails=flightDetails= searchFlightService.searchFlightDetails();
				return new ResponseEntity<>(searchFlightDetails,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getFlightName())){
				List<FlightDetails> searchFlightDetailsBasedOnFlightName = searchFlightService.searchFlightDetailsBasedOnFlightName();
				return new ResponseEntity<>(searchFlightDetailsBasedOnFlightName, HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getBoarding())){
				List<FlightDetails> searchFlightDetailsBasedOnBoarding = searchFlightService.searchFlightDetailsBasedOnBorading();
				return new ResponseEntity<>(searchFlightDetailsBasedOnBoarding,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getDestination())){
				List<FlightDetails> searchFlightDetailsBasedOnDestination = searchFlightService.searchFlightDetailsBasedOnDestination();
				return new ResponseEntity<>(searchFlightDetailsBasedOnDestination,HttpStatus.OK);
			}
			
			if(sortParam.equals(flightdetails.getDateOfJourney().toString())){
				List<FlightDetails> searchFlightDetailsBasedOnDateOfJourney = searchFlightService.searchFlightDetailsBasedOnDateOfJourney();
				return new ResponseEntity<>(searchFlightDetailsBasedOnDateOfJourney, HttpStatus.OK);
			}
			if(sortParam.equals(flightdetails.getTimeOfJourney().toString())){
				List<FlightDetails> searchFlightDetailsBasedOnTimeOfJourney = searchFlightService.searchFlightDetailsBasedOnTimeOfJourney();
				return new ResponseEntity<>(searchFlightDetailsBasedOnTimeOfJourney, HttpStatus.OK);
			}
			
			if(sortParam.equals(String.valueOf(flightdetails.getPrice()))){
				List<FlightDetails> searchFlightDetailsBasedOnPrice = searchFlightService.searchFlightDetailsBasedOnPrice();
				return new ResponseEntity<>(searchFlightDetailsBasedOnPrice, HttpStatus.OK);
			}
			
			if(sortParam.equals(String.valueOf(flightdetails.getDuration()))){
				List<FlightDetails> searchFlightDetailsBasedOnDuration = searchFlightService.searchFlightDetailsBasedOnDuration();
				return new ResponseEntity<>(searchFlightDetailsBasedOnDuration, HttpStatus.OK);
			}
			
		}
		catch(ApplicationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(flightDetails, HttpStatus.OK);
		
	}
	
	
	private void validateFields(FlightDetails flightDetails) throws ApplicationException{
		
		if((flightDetails.getBoarding()==null) || "".equals(flightDetails.getBoarding())){
			throw new ApplicationException("Invalid Boarding Details");
		}
		

		if((flightDetails.getDestination()==null) || "".equals(flightDetails.getDestination())){
			throw new ApplicationException("Invalid Destination Details");
		}
		
		if((flightDetails.getDateOfJourney()==null) || "".equals(flightDetails.getDateOfJourney().toString())){
			throw new ApplicationException("Invalid Date of Journey Details");
		}
		
		if((flightDetails.getTimeOfJourney()==null) || "".equals(flightDetails.getTimeOfJourney().toString())){
			throw new ApplicationException("Invalid Time of Journey Details");
		}
	}
		
		

}

