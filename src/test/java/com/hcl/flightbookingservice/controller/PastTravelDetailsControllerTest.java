package com.hcl.flightbookingservice.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.service.PastTravelDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class PastTravelDetailsControllerTest {

	@InjectMocks
	PastTravelDetailsController pastTravelDetailsController;
	
	@Mock
	PastTravelDetailsService pastTravelDetailsService;
	
	@Before
	public void setup() {
		
	}
}
