package com.hcl.flightbookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.repository.PastTravelDetailsRepository;

@Service
public class PastTravelDetailsService {

	@Autowired
	PastTravelDetailsRepository pastTravelDetailsRepository;
	
	public List<> getPastTravelDetails(String userName){
		
	}
}
