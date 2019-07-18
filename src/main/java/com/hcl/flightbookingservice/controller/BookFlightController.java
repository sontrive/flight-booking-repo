package com.hcl.flightbookingservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.BookFlightRequest;

@RestController
@RequestMapping("/flight")
public class BookFlightController {

	/*
	 * This method is used to book flight based on given details
	 * @param bookFlightRequest
	 * @return 
	 */
	
	@PostMapping("/bookflight")
	public ResponseEntity<?> bookFlight(@RequestBody BookFlightRequest bookFlightRequest){
		return null;
	}
}
