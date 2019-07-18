package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.service.PastTravelDetailsService;

@RestController
@RequestMapping("/pastTravels")
public class PastTravelDetailsController {

	@Autowired
	PastTravelDetailsService pastTravelDetailsService;
	
	@GetMapping("/getBookingHistory")
	public ResponseEntity<Object> getBookingHistory(@RequestParam("customerFirstName") String userName){
		if(null == userName || "".equals(userName)) {
			return new ResponseEntity<>("Please provide username to get past travels details.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
