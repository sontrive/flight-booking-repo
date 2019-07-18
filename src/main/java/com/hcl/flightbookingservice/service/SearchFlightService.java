package com.hcl.flightbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.repository.SearchFlightRepository;

@Service
public class SearchFlightService {
	
	@Autowired
	SearchFlightRepository searchFlightRepository;
	
	

}
