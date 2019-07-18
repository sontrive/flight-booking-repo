package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.entity.FlightDetails;
import com.hcl.flightbookingservice.exception.ApplicationException;
import com.hcl.flightbookingservice.service.SearchFlightService;


@RestController
@RequestMapping("/searchflight")
public class SearchFlightController {
	
	@Autowired
	SearchFlightService searchFlightService;
	
	
	
	private void validateFields(FlightDetails flightDetails) throws ApplicationException{
		
		if(flightDetails.getBoarding()==null) || "".equals(flightDetails.getBoarding())){
			throw new 
		}
		
		if(isNullorEmpty())

}
}
