package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.BookFlightRequest;
import com.hcl.flightbookingservice.domain.BookFlightResponse;
import com.hcl.flightbookingservice.exception.ApplicationException;
import com.hcl.flightbookingservice.service.BookFlightService;

@RestController
@RequestMapping("/flight")
public class BookFlightController {

	
	@Autowired
	BookFlightService bookFlightService;
	
	/*
	 * This method is used to book flight based on given details
	 * @param bookFlightRequest
	 * @return 
	 */
	@PostMapping("/bookflight")
	public ResponseEntity<Object> bookFlight(@RequestBody BookFlightRequest bookFlightRequest){
		BookFlightResponse bookFlight = null;
		try {
			bookFlight = bookFlightService.bookFlight(bookFlightRequest);
		}catch (ApplicationException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		return new ResponseEntity<>(bookFlight, HttpStatus.OK);
	}
}
