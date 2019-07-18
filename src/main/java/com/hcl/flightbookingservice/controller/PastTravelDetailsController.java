package com.hcl.flightbookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;
import com.hcl.flightbookingservice.service.PastTravelDetailsService;

@RestController
@RequestMapping("/pastTravels")
public class PastTravelDetailsController {

	@Autowired
	PastTravelDetailsService pastTravelDetailsService;

	@GetMapping("/getBookingHistory")
	public ResponseEntity<Object> getBookingHistory(@RequestParam("userName") String userName) {

		if (null == userName || "".equals(userName)) {
			return new ResponseEntity<>("Please provide username to get past travels details.", HttpStatus.BAD_REQUEST);
		}
		List<BookingDetailsHistory> bookingDetails = pastTravelDetailsService.getPastTravelDetails(userName);
		return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
	}
}
